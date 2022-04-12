package br.com.possoler.api.api_posso_ler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.possoler.api.api_posso_ler.entity.Conteudo;
import br.com.possoler.api.api_posso_ler.repository.ConteudoRepository;

@Service
public class ConteudoService {
    
    @Autowired
    ConteudoRepository conteudoRepository;

    /**
     * Pega e retorna a entidade Conteudo
     * @return Conteudo
     */
    public Conteudo getConteudoEntity()
    {
        return conteudoRepository
            .findById(0)
            .orElseThrow(() -> new RuntimeException("Falha ao obter conteudo"));
    }
}
