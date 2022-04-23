package br.com.possoler.api.api_posso_ler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.possoler.api.api_posso_ler.entity.Site;
import br.com.possoler.api.api_posso_ler.exceptions.ServerErrorException;
import br.com.possoler.api.api_posso_ler.repository.SiteRepository;

@Service
public class SiteService {
    
    @Autowired
    SiteRepository siteRepository;

    /**
     * Retorna Site de acordo com o id informado no parametro
     * @author thomazf
     * @param site_id
     * @return Site
     */
    public Site getSiteEntityById(Integer site_id)
    {
        return siteRepository.findById(site_id)
            .orElseThrow(() -> new ServerErrorException("Falha ao obter Site"));
    }
}
