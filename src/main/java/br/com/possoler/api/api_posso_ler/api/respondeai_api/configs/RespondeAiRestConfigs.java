package br.com.possoler.api.api_posso_ler.api.respondeai_api.configs;

import br.com.possoler.api.api_posso_ler.api.utils.rest_connection.RestConnection;
import exceptions.ClientErrorException;
import exceptions.ServerErrorException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RespondeAiRestConfigs extends RestConnection {

    /**
     * Setta headers para chamada da API externa
     * @author snowon
     * @return HttpHeaders
     */
    protected final HttpHeaders setHeaders(String jwtToken)
    {
        if(jwtToken.length() == 0)
            throw new ClientErrorException("Token de autenticação não foi fornecido");

        HttpHeaders header = new HttpHeaders();
        header.set("Origin", "https://app.respondeai.com.br");
        header.set("Content-Type", "application/json");
        header.set("User-JWT", jwtToken);
        return header;
    }

    /**
     * Valida status code da resposta vinda da API externa
     * @param response
     */
    protected String getBody(ResponseEntity<String> response) {
        if(response.getStatusCode().is5xxServerError()) {
            throw new ServerErrorException("Falha ao obter os dados");
        }
        if((response.getStatusCode() == HttpStatus.OK && !response.hasBody()) || response.getStatusCode() == HttpStatus.NOT_FOUND) {
            throw new ServerErrorException("Não há conteúdos para exibir");
        }
        return response.getBody();
    }
}
