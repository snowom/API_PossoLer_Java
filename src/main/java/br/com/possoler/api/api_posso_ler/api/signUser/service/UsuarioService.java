package br.com.possoler.api.api_posso_ler.api.signUser.service;

import br.com.possoler.api.api_posso_ler.api.core_api.service.DownloadService;
import br.com.possoler.api.api_posso_ler.api.signUser.model.Usuario;
import br.com.possoler.api.api_posso_ler.api.signUser.repository.UsuarioRepository;
import exceptions.NotFoundException;
import exceptions.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;
    private final DownloadService downloadService;
    private final HashService hashService;

    UsuarioService(DownloadService downloadService, HashService hashService) {
        this.downloadService = downloadService;
        this.hashService = hashService;
    }

    public String insereUsuario() {
        var userHash = hashService.generateHash();
        var userCode = hashService.getUserCode();

        Usuario user = Usuario.builder()
            .hash(userHash)
            .codigo(userCode)
            .ativo(false)
            .build();
        usuarioRepository.save(user);
        return userHash;
    }

    public HashMap<String, String> isUniqueUser(String hash) {
        HashMap<String, String> response = new HashMap<>();
        List<Usuario> usuarios = buscaUsuariosPorHash(hash);

        switch (usuarios.toArray().length) {
            case 0 -> {
                response.put("message", "hash inválido");
                response.put("status", "falha");
            }
            case 1 -> {
                response.put("message", "autentica");
                response.put("status", "sucesso");
            }
            default -> {
                response.put("message", "copia");
                response.put("status", "falha");
            }
        }
        return response;
    }

    public void activeUser(String hash) {
        List<Usuario> usuarios = findUserByHashAndActiveFlag(hash, false);
        switch (usuarios.toArray().length) {
            case 0 -> throw new NotFoundException("chave inválida!");
            case 1 -> {
                Usuario usuario = usuarios.get(0);
                usuario.setAtivo(true);
                usuarioRepository.save(usuario);
                downloadService.incrementDownload();
            }
            default -> throw new ServerErrorException("hash duplicado!");
        }
    }

    private List<Usuario> buscaUsuariosPorHash(String hash) {
        return usuarioRepository.findByHash(hash)
            .orElseThrow(() -> new ServerErrorException("falha ao localizar usuário"));
    }

    public List<Usuario> findUserByHashAndActiveFlag(String hash, Boolean activeFlag) {
        return usuarioRepository.findByHashAndAtivo(hash, activeFlag)
            .orElseThrow(() -> new ServerErrorException("falha ao localizar usuário"));
    }
}
