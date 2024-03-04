package br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.interceptor;

import br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.service.AuthTokenService;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthTokenInterceptor implements HandlerInterceptor {

    private final AuthTokenService authTokenService;

    public AuthTokenInterceptor(AuthTokenService authTokenService) {
        this.authTokenService = authTokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        authTokenService.validateUser(request);
        return true;
    }
}
