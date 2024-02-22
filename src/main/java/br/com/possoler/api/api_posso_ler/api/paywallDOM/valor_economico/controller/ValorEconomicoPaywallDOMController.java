package br.com.possoler.api.api_posso_ler.api.paywallDOM.valor_economico.controller;

import br.com.possoler.api.api_posso_ler.api.paywallDOM.service.PaywallDOMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ValorEconomicoPaywallDOMController {

    private final String FILENAME = "valoreconomico.json";
    private final PaywallDOMService paywallDOMService;

    public ValorEconomicoPaywallDOMController(PaywallDOMService paywallDOMService) {
        this.paywallDOMService = paywallDOMService;
    }

    @GetMapping("${paywalldom-api.endpoint.valorecon}")
    private ResponseEntity<?> getPaywallDOMValorEconomico() {
        Object valorEconomicoConfigModel = paywallDOMService.getConfig(FILENAME);
        return ResponseEntity.ok().body(valorEconomicoConfigModel);
    }
}
