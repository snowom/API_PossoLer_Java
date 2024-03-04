package br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.config;

import br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.interceptor.AuthTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RegisterInterceptors implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthTokenInterceptor()); // é possível adicionar a função .addPathPatterns() para definir um pattern de url em que a interceptação será feita
    }
}
