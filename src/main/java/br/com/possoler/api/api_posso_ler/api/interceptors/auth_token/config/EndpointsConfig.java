package br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EndpointsConfig {

    @Autowired
    private Environment environment;

    @Bean
    public List<String> getEndpointsFromEnviroment() {
        List<String> endpoints = new ArrayList<>();

        endpoints.add(environment.getProperty("core-api.endpoint.increment-download"));
        endpoints.add(environment.getProperty("core-api.endpoint.download-extension"));
        endpoints.add(environment.getProperty("cachemock-api.endpoint.getQuantityFilesUnlocked"));
        endpoints.add(environment.getProperty("cachemock-api.endpoint.clearUnlockedFiles"));
        endpoints.add(environment.getProperty("signuser-api.endpoint.genHash"));
        endpoints.add(environment.getProperty("signuser-api.endpoint.insertHashedUser"));
        endpoints.add(environment.getProperty("signuser-api.endpoint.checkUniqueUser"));
        endpoints.add(environment.getProperty("signuser-api.endpoint.activeUser"));

        return endpoints;
    }
}
