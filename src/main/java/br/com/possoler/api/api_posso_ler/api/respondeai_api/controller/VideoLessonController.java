package br.com.possoler.api.api_posso_ler.api.respondeai_api.controller;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request.LeassonRequestDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.interfaces.RespondeAiConnection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class VideoLessonController {

    private final RespondeAiConnection respondeAiConnection;

    public VideoLessonController(@Qualifier("getLeasson") RespondeAiConnection respondeAiConnection){
        this.respondeAiConnection = respondeAiConnection;
    }

    @PostMapping("${respondeai-api.endpoint.getVideoLeassonData}")
    private ResponseEntity<Object> getVideoLessons(
        @RequestHeader("Authorization") String token,
        @RequestBody @Valid LeassonRequestDTO leassonRequestDTO
    ){
        Object response = respondeAiConnection.getData(leassonRequestDTO.getLeassonId(), token);
        return ResponseEntity.ok().body(response);
    }
}
