package br.com.possoler.api.api_posso_ler.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.possoler.api.api_posso_ler.dto.DadosAcessoDTO;
import br.com.possoler.api.api_posso_ler.dto.SiteAccessDTO;
import br.com.possoler.api.api_posso_ler.entity.DadosAcesso;
import br.com.possoler.api.api_posso_ler.entity.Site;
import br.com.possoler.api.api_posso_ler.service.DadosAcessoService;
import br.com.possoler.api.api_posso_ler.service.SiteService;

@RestController
@RequestMapping("/API")
public class DadosAcessoController {
    
    @Autowired
    DadosAcessoService dadosAcessoService;
    @Autowired
    SiteService siteService;

    /**
     * Insere dados (codigo_site, data e horario de acesso) de site acessado pela extensão
     * @author thomazf
     * @param dto
     * @return ResponseEntity
     */
    @PostMapping("/acessos/insertDadosAccess")
    private ResponseEntity<Map<String, String>> insertDadosAccess(@RequestBody @Valid DadosAcessoDTO dto)
    {
        Site site = siteService.getSiteEntityById(dto.getCodigo_site());
        DadosAcesso dadosAcesso = DadosAcessoDTO.parseToEntity(dto, site);
        return dadosAcessoService.insertDados(dadosAcesso);
    }


    /**
     * Retorna em ordem decrescente a quantidade total de acessos dos sites
     * @author thomazf
     * @return ResponseEntity
     */
    @GetMapping("/chart/countAllSitesAccess")
    private ResponseEntity<List<SiteAccessDTO>> getAllSitesAccess()
    {
        return dadosAcessoService.countAllSitesAccess();
    }
}
