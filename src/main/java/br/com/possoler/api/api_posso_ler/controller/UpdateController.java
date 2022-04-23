package br.com.possoler.api.api_posso_ler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.possoler.api.api_posso_ler.entity.SnackbarUpdate;
import br.com.possoler.api.api_posso_ler.service.SnackbarUpdateService;

@RestController
@RequestMapping("/API")
public class UpdateController {

    @Autowired
    private SnackbarUpdateService snackbarUpdateService;

    /**
     * Retorna dados da versão mais atual da extensão
     * @author thomazf
     * @return ResponseEntity
     */
    @GetMapping("/searchUpdates")
    private ResponseEntity<SnackbarUpdate> searchUpdates()
    {
        SnackbarUpdate snkUpdate = snackbarUpdateService.setValues();
        return ResponseEntity.ok().body(snkUpdate);
    }
}
