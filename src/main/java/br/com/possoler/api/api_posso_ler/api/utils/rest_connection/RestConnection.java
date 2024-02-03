package br.com.possoler.api.api_posso_ler.api.utils.rest_connection;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConnection {

    private RestTemplate restTemplate;
    private HttpEntity<?> entity;

    protected RestConnection() {
        restTemplate = new RestTemplate();
    }

    protected ResponseEntity<String> get(String URL, HttpHeaders headers) {
        entity = new HttpEntity<>(headers);
        return restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
    }

    protected ResponseEntity<String> get(String URL) {
        entity = new HttpEntity<>(null);
        return restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
    }
}
