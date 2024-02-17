package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.controller;

import br.com.possoler.api.api_posso_ler.api.paywallDOM.service.PaywallDOMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class RespondeAiPaywallDOMController {

    private final String FILENAME = "respondeai.json";
    private final PaywallDOMService paywallDOMService;

    public RespondeAiPaywallDOMController(PaywallDOMService paywallDOMService) {
        this.paywallDOMService = paywallDOMService;
    }

    @GetMapping("${paywalldom-api.endpoint.respai}")
    public ResponseEntity<?> getPaywallDOMConfigsRespondeAI() {
        Object response = paywallDOMService.getConfig(FILENAME);
        return ResponseEntity.ok().body(response);
    }
}
