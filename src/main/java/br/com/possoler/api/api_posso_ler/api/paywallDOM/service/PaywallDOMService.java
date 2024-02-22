package br.com.possoler.api.api_posso_ler.api.paywallDOM.service;

import br.com.possoler.api.api_posso_ler.api.paywallDOM.config.PaywallDOMConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ServerErrorException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PaywallDOMService {

    private final String FILEPATH;

    public PaywallDOMService(PaywallDOMConfig paywallDOMConfig) {
        FILEPATH = paywallDOMConfig.setFilepath();
    }

    public Object getConfig(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(FILEPATH + filename), Object.class);
        } catch (IOException | RuntimeException e) {
            throw new ServerErrorException("Falha ao recuperar configurações");
        }
    }
}
