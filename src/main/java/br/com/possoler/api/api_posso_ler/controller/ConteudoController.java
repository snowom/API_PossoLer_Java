package br.com.possoler.api.api_posso_ler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.possoler.api.api_posso_ler.dto.ConteudoDTO;
import br.com.possoler.api.api_posso_ler.entity.Conteudo;
import br.com.possoler.api.api_posso_ler.service.ConteudoService;

@RestController
@RequestMapping("/API")
public class ConteudoController {

    @Autowired
    ConteudoService conteudoService;
    
    @GetMapping("/getConteudos")
    public ResponseEntity<ConteudoDTO> teste()
    {
        Conteudo conteudo = conteudoService.getConteudoEntity();
        return ResponseEntity.ok().body(ConteudoDTO.parseToDTO(conteudo));
    }
}
