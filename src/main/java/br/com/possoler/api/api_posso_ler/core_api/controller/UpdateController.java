package br.com.possoler.api.api_posso_ler.core_api.controller;

import br.com.possoler.api.api_posso_ler.core_api.entity.SnackbarUpdate;
import br.com.possoler.api.api_posso_ler.core_api.service.SnackbarUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    @Autowired
    private SnackbarUpdateService snackbarUpdateService;

    /**
     * Retorna dados da versão mais atual da extensão
     * @author thomazf
     * @return ResponseEntity
     */
    @GetMapping("${core-api.endpoint.search-updates}")
    private ResponseEntity<SnackbarUpdate> searchUpdates()
    {
        SnackbarUpdate snkUpdate = snackbarUpdateService.setValues();
        return ResponseEntity.ok().body(snkUpdate);
    }
}
