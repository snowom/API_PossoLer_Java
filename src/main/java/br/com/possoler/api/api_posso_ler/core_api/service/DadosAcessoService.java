package br.com.possoler.api.api_posso_ler.core_api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.possoler.api.api_posso_ler.core_api.dto.SiteAccessDTO;
import br.com.possoler.api.api_posso_ler.core_api.entity.DadosAcesso;
import br.com.possoler.api.api_posso_ler.core_api.repository.DadosAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import exceptions.ServerErrorException;

@Service
public class DadosAcessoService {
    
    @Autowired
    DadosAcessoRepository dadosAcessoRepository;

    /**
     * Insere dados de acesso no BD
     * @author thomazf
     * @param dadosAcesso
     * @return ResponseEntity
     */
    public ResponseEntity<Map<String, String>> insertDados(DadosAcesso dadosAcesso)
    {
        Map<String, String> response = new HashMap<>();
        try{
            dadosAcessoRepository.save(dadosAcesso);
            response.put("STATUS", "Sucesso ao executar query!");
            return ResponseEntity.status(201).body(response);
        }catch(Exception e){
            response.put("STATUS", "Falha ao executar Query");
            return ResponseEntity.internalServerError().body(response);
        }
    }


    /**
     * Retorna todos os sites cadastrados no BD e sua respectiva quantidade de acessos pela extensão
     * @author thomazf
     * @return ResponseEntity
     */
    public ResponseEntity<List<SiteAccessDTO>> countAllSitesAccess()
    {
        List<SiteAccessDTO> sitesAccess = this.getDadosFromSites();
        return ResponseEntity.ok().body(sitesAccess);
    }


    /**
     * Retorna as infos dos sites cadastrados no BD
     * @author thomazf
     * @return List
     */
    private List<SiteAccessDTO> getDadosFromSites()
    {
        return dadosAcessoRepository.findByCodigoSite()
            .orElseThrow(() -> new ServerErrorException("Falha ao recuperar dados dos sites"));
    }
}
