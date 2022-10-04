package br.com.possoler.api.api_posso_ler.respondeai_api.service;

import br.com.possoler.api.api_posso_ler.respondeai_api.constants.Request;
import br.com.possoler.api.api_posso_ler.respondeai_api.dto.ExerciseRequestDTO;
import br.com.possoler.api.api_posso_ler.respondeai_api.dto.ExerciseRequestPayloadDTO;
import br.com.possoler.api.api_posso_ler.respondeai_api.entity.Variables;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ClientErrorException;
import exceptions.NotFoundException;
import exceptions.ServerErrorException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RespondeAiService {

    private RestTemplate restTemplate = new RestTemplate();
    private HttpMethod httpMethod;
    private HttpEntity<?> entity;
    private ResponseEntity response;


    /**
     * Realiza Requisicao para API do Responde Ai e retorna objeto obtido na requisicao
     * @author snowom
     * @param payload
     * @param token
     * @return DataBookExerciseResponseDTO
     */
    public Object getData(String operation, ExerciseRequestDTO payload, String token)
    {
        HttpHeaders header = this.setHeaders(token);
        String URI = buildURIRequest(operation, payload.getExerciseId());

        if((isBookData(operation))){
            this.httpMethod = HttpMethod.GET;
            this.entity = new HttpEntity<>(header);
        }else{
            this.httpMethod = HttpMethod.POST;
            String operationName = defineOperationName(operation);
            String query = defineQuery(operation);
            ExerciseRequestPayloadDTO bodyRequest = this.buildBodyRequest(operationName, query, payload.getExerciseId());
            this.entity = new HttpEntity<>(bodyRequest, header);
        }

        this.response = restTemplate.exchange(URI, this.httpMethod, entity, String.class);

        if(!this.response.hasBody())
            throw new NotFoundException("Não há conteúdos para exibir");

        String responseBody = (String)this.response.getBody();
        return this.parseResponseToEntity(responseBody);
    }

    private ExerciseRequestPayloadDTO buildBodyRequest(String operationName, String query, String exerciseId) {
        return ExerciseRequestPayloadDTO
            .builder()
            .operationName(operationName)
            .query(query)
            .variables(Variables.builder().id(exerciseId).build())
            .build();
    }

    private String defineQuery(String operation) throws ClientErrorException{
        if(operation.equalsIgnoreCase(Request.Operation.THEORY.getOperationValue())){
            return Request.THEORY_QUERY;
        }
        if(operation.equalsIgnoreCase(Request.Operation.FIXATION_EXERCISE.getOperationValue())){
            return Request.FIXATION_EXERCISE_QUERY;
        }
        if(operation.equalsIgnoreCase(Request.Operation.LIST_EXERCISE.getOperationValue())){
            return Request.LIST_EXERCISE_OPERATION_QUERY;
        }
        throw new ClientErrorException("Valor do parâmetro operation inválido");
    }

    private String defineOperationName(String operation) throws ClientErrorException{
        if(operation.equalsIgnoreCase(Request.Operation.THEORY.getOperationValue())){
            return Request.THEORY_OPERATION_NAME;
        }
        if(operation.equalsIgnoreCase(Request.Operation.FIXATION_EXERCISE.getOperationValue())){
            return Request.FIXATION_EXERCISE_OPERATION_NAME;
        }
        if(operation.equalsIgnoreCase(Request.Operation.LIST_EXERCISE.getOperationValue())){
            return Request.LIST_EXERCISE_OPERATION_NAME;
        }
        throw new ClientErrorException("Valor do parâmetro operation inválido");
    }

    private Boolean isBookData(String operation){
        return operation.equalsIgnoreCase(Request.Operation.BOOK_EXERCISE.getOperationValue());
    }

    /**
     * Gera URI de request para API do Responde Aí
     * @author snowon
     * @param exerciseId
     * @return String
     */
    private String buildURIRequest(String operation, String exerciseId) {

        if(operation.equalsIgnoreCase(Request.Operation.BOOK_EXERCISE.getOperationValue())){
            return Request.DOMAIN_REQUEST + Request.BOOK_EXERCISE_ENDPOINT_REQUEST + exerciseId;
        }
        if(
            operation.equalsIgnoreCase(Request.Operation.THEORY.getOperationValue()) ||
            operation.equalsIgnoreCase(Request.Operation.FIXATION_EXERCISE.getOperationValue()) ||
            operation.equalsIgnoreCase(Request.Operation.LIST_EXERCISE.getOperationValue())
        ){
            return Request.DOMAIN_REQUEST + Request.THEORY_ENDPOINT;
        }
        return null;
    }

    /**
     * Converte resposta do request (JSON) em uma entity
     * @author snowon
     * @param response
     * @return DataBookExerciseResponseDTO
     */
    private Object parseResponseToEntity(String response)
    {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, Object.class);
        }catch(IOException e){
            throw new ServerErrorException(e.getMessage());
        }
    }

    /**
     * Setta headers para chamada da API externa
     * @author snowon
     * @return HttpHeaders
     */
    public HttpHeaders setHeaders(String jwtToken)
    {
        if(jwtToken.length() == 0)
            throw new ClientErrorException("Token de autenticação não foi fornecido");

        HttpHeaders header = new HttpHeaders();
        header.set("Content-Type", "application/json");
        header.set("User-JWT", jwtToken);
        return header;
    }
}
