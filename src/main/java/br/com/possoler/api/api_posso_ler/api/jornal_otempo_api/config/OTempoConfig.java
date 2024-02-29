package br.com.possoler.api.api_posso_ler.api.jornal_otempo_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class OTempoConfig {

    @Autowired
    private Environment environment;

    /**
     * Retorna o valor da configuracao
     * @author snowom
     * @return String
     */
    @Bean
    public String getDashBoardApiUrl() {
        var dashboardApiUrl = environment.getProperty("jornal-o-tempo-api.variable.dashboard-api-url");
        return dashboardApiUrl == null ? "" : dashboardApiUrl;
    }

    /**
     * Retorna o valor da configuracao
     * @author snowom
     * @return String
     */
    @Bean
    public String getCookieAllowCredit() {
        var cookieAllowCredit = environment.getProperty("jornal-o-tempo-api.variable.cookie-allow-credit");
        return cookieAllowCredit == null ? "" : cookieAllowCredit;
    }

    /**
     * Retorna o valor da configuracao
     * @author snowom
     * @return String
     */
    @Bean
    public String getRestServiceTokenEncoded() {
        var restServiceTokenEncoded = environment.getProperty("jornal-o-tempo-api.variable.o-tempo-rest-service-token-encoded");
        return restServiceTokenEncoded == null ? "" : restServiceTokenEncoded;
    }
}
