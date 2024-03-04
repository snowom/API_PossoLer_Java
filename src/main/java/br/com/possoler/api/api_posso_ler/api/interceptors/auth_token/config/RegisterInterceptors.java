package br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.config;

import br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.interceptor.AuthTokenInterceptor;
import br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.service.AuthTokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class RegisterInterceptors implements WebMvcConfigurer {

    private final AuthTokenService authTokenService;
    private final List<String> endpoints;

    RegisterInterceptors(AuthTokenService authTokenService, EndpointsConfig endpointsConfig) {
        this.authTokenService = authTokenService;
        endpoints = endpointsConfig.getEndpointsFromEnviroment();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthTokenInterceptor(authTokenService))
            .excludePathPatterns(endpoints); // A função .excludePathPatterns() define um pattern de url em que a interceptação não será feita
    }


}
