package br.com.possoler.api.api_posso_ler.api.paywallDOM.service;

import br.com.possoler.api.api_posso_ler.api.utils.PathConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PaywallDOMService {

    @Autowired
    private Environment environment;
    private String FILEPATH;

    public Object getConfig(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(FILEPATH + filename), Object.class);
        } catch (IOException | RuntimeException e) {
            throw new ServerErrorException("Falha ao recuperar configurações");
        }
    }

    @Bean
    private void setFilepath() {
        var scope = environment.getProperty("SCOPE");
        FILEPATH = (scope == null)
            ? System.getProperty("user.dir") + PathConstants.FOLDER_POSSOLER_INTEGRATOR + "/paywallDOM/configFiles/"
            : System.getProperty("user.dir") + "\\src\\main\\resources\\paywallDOM\\configFiles\\";
    }
}
