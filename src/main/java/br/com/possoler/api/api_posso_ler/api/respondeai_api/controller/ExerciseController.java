package br.com.possoler.api.api_posso_ler.api.respondeai_api.controller;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request.ExerciseRequestDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping("${respondeai-api.endpoint.getExerciseData}")
    private ResponseEntity<Object> getExerciseData(
        @RequestHeader(name = "Authorization") String token,
        @RequestBody @Valid ExerciseRequestDTO payload
    ){
        Object response = exerciseService.getExerciseData(payload.getItemId(), token);
        return ResponseEntity.ok().body(response);
    }
}
