package br.com.possoler.api.api_posso_ler.core_api.service;

import br.com.possoler.api.api_posso_ler.core_api.entity.SnackbarUpdate;
import org.springframework.stereotype.Service;

@Service
public class SnackbarUpdateService {


    /**
     * Setta e retorna os valores da entity SnackbarUpdate
     * @author thomazf
     * @return SnackbarUpdate
     */
    public SnackbarUpdate setValues()
    {
        return SnackbarUpdate.builder()
        .currentVersion("144")
        .buttonMessage("Vamos lá")
        .message("Uma nova versão do \"Posso Ler?\" já está disponível para download!")
        .time(10).build();
    }
}
