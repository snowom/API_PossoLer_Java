package br.com.possoler.api.api_posso_ler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.possoler.api.api_posso_ler.entity.SnackbarUpdate;

@Service
public class SnackbarUpdateService {


    /**
     * Setta e retorna os valores da entity SnackbarUpdate
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
