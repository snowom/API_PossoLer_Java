package br.com.possoler.api.api_posso_ler.api.respondeai_api.controller;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.request.LessonRequestDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.interfaces.RespondeAiConnection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class VideoLessonController {

    private final RespondeAiConnection respondeAiConnection;

    public VideoLessonController(@Qualifier("getLesson") RespondeAiConnection respondeAiConnection){
        this.respondeAiConnection = respondeAiConnection;
    }

    @PostMapping("${respondeai-api.endpoint.getVideoLessonData}")
    private ResponseEntity<Object> getVideoLessons(
        @RequestHeader("Authorization") String token,
        @RequestBody @Valid LessonRequestDTO leassonRequestDTO
    ){
        Object response = respondeAiConnection.getData(leassonRequestDTO.getLessonId(), token);
        return ResponseEntity.ok().body(response);
    }
}
