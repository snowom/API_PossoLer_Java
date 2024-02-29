package br.com.possoler.api.api_posso_ler.api.cachemock_api.config;

import br.com.possoler.api.api_posso_ler.api.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CachemockConfig {

    @Autowired
    private Environment environment;

    @Bean
    public String setFilePath() {
        var scope = environment.getProperty("SCOPE");
        return (scope == null)
            ? System.getProperty("user.dir") + PathConstants.FOLDER_POSSOLER_INTEGRATOR + "/cachemock/jsonFiles/"
            : System.getProperty("user.dir") + "\\src\\main\\resources\\cachemock\\jsonFiles\\";
    }

    @Bean
    public String getAuthPrivateKey() {
        var privateKey = environment.getProperty("cachemock-api.header-auth-private-key");
        return privateKey == null ? "" : privateKey;
    }

    @Bean
    public String getArticleContentRoute() {
        var route = environment.getProperty("cachemock-api.endpoint.getArticleContent");
        return route == null ? "" : route;
    }
}
