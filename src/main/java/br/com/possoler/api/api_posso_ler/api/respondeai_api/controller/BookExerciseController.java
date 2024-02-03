package br.com.possoler.api.api_posso_ler.api.respondeai_api.controller;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request.ExerciseRequestDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.interfaces.RespondeAiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class BookExerciseController {

    private final RespondeAiClient respondeAiClient;

    public BookExerciseController(@Qualifier("getBookExercise") RespondeAiClient respondeAiClient) {
        this.respondeAiClient = respondeAiClient;
    }

    @PostMapping("${respondeai-api.endpoint.getBookExerciseData}")
    private ResponseEntity<Object> getExerciseData(
        @RequestHeader(name = "Authorization") String token,
        @RequestBody @Valid ExerciseRequestDTO payload
    ){
        Object response = respondeAiClient.getData(payload.getItemId(), token);
        return ResponseEntity.ok().body(response);
    }
}
