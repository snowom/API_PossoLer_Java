package br.com.possoler.api.api_posso_ler.api.paywallDOM.config;

import br.com.possoler.api.api_posso_ler.api.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PaywallDOMConfig {

    @Autowired
    private Environment environment;

    @Bean
    public String setFilepath() {
        var scope = environment.getProperty("SCOPE");
        return (scope == null)
            ? System.getProperty("user.dir") + PathConstants.FOLDER_POSSOLER_INTEGRATOR + "/paywallDOM/configFiles/"
            : System.getProperty("user.dir") + "\\src\\main\\resources\\paywallDOM\\configFiles\\";
    }
}
