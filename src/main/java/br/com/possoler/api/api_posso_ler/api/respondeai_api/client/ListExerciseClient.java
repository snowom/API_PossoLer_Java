package br.com.possoler.api.api_posso_ler.api.respondeai_api.client;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.configs.RespondeAiRestConfigs;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.constants.RequestEndpoints;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.interfaces.RespondeAiClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component("ListExerciseClient")
public class ListExerciseClient extends RespondeAiRestConfigs implements RespondeAiClient {

    @Override
    public Object getData(String itemId, String token) {
        HttpHeaders header = setHeaders(token);
        final String URI = buildURIRequest(itemId);
        var responseRequest = get(URI, header);
        return getBody(responseRequest);
    }

    @Override
    public String buildURIRequest(String exerciseId) {
        return RequestEndpoints.DOMAIN_REQUEST + RequestEndpoints.LIST_EXERCISE_ENDPOINT + exerciseId;
    }
}
