package br.com.possoler.api.api_posso_ler.respondeai_api.service;

import br.com.possoler.api.api_posso_ler.respondeai_api.dto.BodyRequestDTO;
import br.com.possoler.api.api_posso_ler.respondeai_api.dto.DataBookExerciseResponseDTO;
import br.com.possoler.api.api_posso_ler.respondeai_api.entity.BookExerciseRequestEntity;
import br.com.possoler.api.api_posso_ler.respondeai_api.entity.Variables;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ClientErrorException;
import exceptions.NotFoundException;
import exceptions.ServerErrorException;
import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RespondeAiService {

    @Getter
    private final String URL_REQUEST = "https://content.respondeai.com.br/graphql";
    private final String QUERY = "query bookExercise($id: ID!) {bookExercise(id: $id) {id solution answer}}";
    private final String OPERATION_NAME_BOOK_EXERCISE_SOLVED = "bookExercise";
    private RestTemplate restTemplate = new RestTemplate();


    public DataBookExerciseResponseDTO doRequestToRespodeAi_API(BodyRequestDTO payload, String token)
    {
        BookExerciseRequestEntity requestBody = this.mountRequestBody(payload.getExerciseId());
        HttpHeaders header = this.setHeaders(token);
        HttpEntity<BookExerciseRequestEntity> entity = new HttpEntity<BookExerciseRequestEntity>(requestBody, header);
        ResponseEntity response = restTemplate.exchange(this.URL_REQUEST, HttpMethod.POST, entity, String.class);

        if(!response.hasBody())
            throw new NotFoundException("Não há conteúdos para exibir");
        String responseBody = (String)response.getBody();
        return this.parseResponseToEntity(responseBody);
    }


    /**
     * Converte resposta do request em uma entity
     * @author thomazf
     * @param response
     * @return DataBookExerciseResponseDTO
     */
    private DataBookExerciseResponseDTO parseResponseToEntity(String response)
    {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response, DataBookExerciseResponseDTO.class);
        }catch(IOException e){
            throw new ServerErrorException(e.getMessage());
        }
    }


    /**
     * Monta e retorna payload em forma de entidade para requisição no RespondeAi
     * @author thomazf
     * @return BookExerciseRequestEntity
     */
    private BookExerciseRequestEntity mountRequestBody(String exerciseId)
    {
        return BookExerciseRequestEntity.builder()
                .operationName(this.OPERATION_NAME_BOOK_EXERCISE_SOLVED)
                .query(this.QUERY)
                .variables(Variables.builder()
                        .id(exerciseId)
                        .showBody(false)
                        .build()
                ).build();
    }


    /**
     * Setta headers para chamada da API externa
     * @author thomazf
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
