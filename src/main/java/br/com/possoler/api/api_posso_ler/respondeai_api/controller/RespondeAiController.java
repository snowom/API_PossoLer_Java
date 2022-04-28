package br.com.possoler.api.api_posso_ler.respondeai_api.controller;

import br.com.possoler.api.api_posso_ler.respondeai_api.dto.BodyRequestDTO;
import br.com.possoler.api.api_posso_ler.respondeai_api.dto.DataBookExerciseResponseDTO;
import br.com.possoler.api.api_posso_ler.respondeai_api.service.RespondeAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class RespondeAiController {

    @Autowired
    private RespondeAiService respondeAiService;

    @PostMapping("${respondeai-api.endpoint.getBookExerciseSolution}")
    private ResponseEntity<?> getBookExerciseSolution(
            @RequestHeader(name = "Authorization") String token,
            @RequestBody @Valid BodyRequestDTO payload
    ){
        DataBookExerciseResponseDTO response = respondeAiService.doRequestToRespodeAi_API(payload, token);
        return ResponseEntity.ok().body(response);
    }
}
