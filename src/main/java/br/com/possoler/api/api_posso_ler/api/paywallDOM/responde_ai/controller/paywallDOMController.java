package br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.controller;

import br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.model.RespondeAiConfigModel;
import br.com.possoler.api.api_posso_ler.api.paywallDOM.responde_ai.service.PaywallDOMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class paywallDOMController {

    @Autowired
    PaywallDOMService paywallDOMService;

    @GetMapping("${paywalldom-api.endpoint.respai}")
    public ResponseEntity<RespondeAiConfigModel> getPaywallDOMConfigsRespondeAI() {
        RespondeAiConfigModel response = paywallDOMService.buildRespondeAiConfigs();
        return ResponseEntity.ok().body(response);
    }
}
