package br.com.possoler.api.api_posso_ler.api.core_api.service;

import java.util.Arrays;
import java.util.List;

import br.com.possoler.api.api_posso_ler.api.core_api.dto.MessageDTO;
import br.com.possoler.api.api_posso_ler.api.core_api.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    /**
     * Preenche DTO e o retorna
     * @author thomazf
     * @return MessageDTO
     */
    public MessageDTO buildMessages()
    {
        List<Message> msgList = Arrays.asList(
          //Message.builder().msg("MSG 1").time(10).build(),
          //Message.builder().msg("MSG 2").time(30).build()
        );
        return MessageDTO.setMessages(msgList);
    }
}
