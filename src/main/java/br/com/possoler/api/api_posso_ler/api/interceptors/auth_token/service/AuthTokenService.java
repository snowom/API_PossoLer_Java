package br.com.possoler.api.api_posso_ler.api.interceptors.auth_token.service;

import br.com.possoler.api.api_posso_ler.api.signUser.service.UsuarioService;
import exceptions.ClientErrorException;
import exceptions.InvalidUserAuthTokenException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class AuthTokenService {

    private final UsuarioService usuarioService;

    AuthTokenService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void validateUser(HttpServletRequest request) {
        final Boolean USER_ACTIVE_FLAG = true;
        var authToken = request.getHeader("X-USER-AUTH");

        if(authToken == null || authToken.isEmpty()) {
            throw new ClientErrorException("Missing or empty X-USER-AUTH header");
        }

        var user = usuarioService.findUserByHashAndActiveFlag(authToken, USER_ACTIVE_FLAG);
        if (user.toArray().length <= 0) {
            throw new InvalidUserAuthTokenException("Invalid user token");
        }
    }
}
