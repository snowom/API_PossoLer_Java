package br.com.possoler.api.api_posso_ler.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.possoler.api.api_posso_ler.dto.MessageDTO;
import br.com.possoler.api.api_posso_ler.entity.Message;
import br.com.possoler.api.api_posso_ler.service.MessageService;

@RestController
@RequestMapping("/API")
public class MessageController {

    @Autowired
    MessageService messageService;
    
    @GetMapping("/searchMessages")
    private ResponseEntity<MessageDTO> getMessages()
    {
        MessageDTO dto = messageService.fillDTO();
        return ResponseEntity.ok().body(dto);
    }
}
