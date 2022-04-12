package br.com.possoler.api.api_posso_ler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.possoler.api.api_posso_ler.entity.Download;
import br.com.possoler.api.api_posso_ler.repository.DownloadRepository;

@Service
public class DownloadService {
    
    @Autowired
    DownloadRepository downloadsRepository;

    /**
     * Pega e retorna a entidade Download
     * @return Integer
     */
    public Download getDownloadEntity()
    {
        return downloadsRepository
            .findById(0)
            .orElseThrow(() -> new RuntimeException("Falha ao obter download"));
    }
}
