package br.com.possoler.api.api_posso_ler.api.respondeai_api.controller;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request.ExerciseRequestDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.service.ListExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class ListExerciseController {

    private final ListExerciseService listExerciseService;

    public ListExerciseController(ListExerciseService listExerciseService) {
        this.listExerciseService = listExerciseService;
    }

    @PostMapping("${respondeai-api.endpoint.getListExerciseData}")
    private ResponseEntity<Object> getListExerciseData(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody @Valid ExerciseRequestDTO payload
    ){
        Object response = listExerciseService.getListExerciseData(payload.getItemId(), token);
        return ResponseEntity.ok().body(response);
    }
}
