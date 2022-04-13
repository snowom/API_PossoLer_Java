package br.com.possoler.api.api_posso_ler.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.possoler.api.api_posso_ler.dto.DadosAcessoDTO;
import br.com.possoler.api.api_posso_ler.entity.DadosAcesso;
import br.com.possoler.api.api_posso_ler.service.DadosAcessoService;

@RestController
@RequestMapping("/API/acessos")
public class DadosAcessoController {
    
    @Autowired
    DadosAcessoService dadosAcessoService;

    @PostMapping("/insertDadosAccess")
    private ResponseEntity<Map<String, String>> insertDadosAccess(@RequestBody @Valid DadosAcessoDTO dto)
    {
        DadosAcesso dadosAcesso = DadosAcessoDTO.parseToEntity(dto);
        return dadosAcessoService.insertDados(dadosAcesso);
    }
}
