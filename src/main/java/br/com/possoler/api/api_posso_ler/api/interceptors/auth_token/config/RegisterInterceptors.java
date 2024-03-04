package br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.config;

import br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.interceptor.AuthTokenInterceptor;
import br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.service.AuthTokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterInterceptors implements WebMvcConfigurer {

    private final AuthTokenService authTokenService;

    RegisterInterceptors(AuthTokenService authTokenService) {
        this.authTokenService = authTokenService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthTokenInterceptor(authTokenService)); // é possível adicionar a função .addPathPatterns() para definir um pattern de url em que a interceptação será feita
    }
}
