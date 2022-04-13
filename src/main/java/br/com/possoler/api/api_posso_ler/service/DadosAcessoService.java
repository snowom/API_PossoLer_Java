package br.com.possoler.api.api_posso_ler.service;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.possoler.api.api_posso_ler.entity.DadosAcesso;
import br.com.possoler.api.api_posso_ler.repository.DadosAcessoRepository;

@Service
public class DadosAcessoService {
    
    @Autowired
    DadosAcessoRepository dadosAcessoRepository;

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
}
