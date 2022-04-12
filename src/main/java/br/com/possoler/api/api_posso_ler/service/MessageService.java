package br.com.possoler.api.api_posso_ler.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.possoler.api.api_posso_ler.dto.MessageDTO;
import br.com.possoler.api.api_posso_ler.entity.Message;

@Service
public class MessageService {
    
    /**
     * Preenche DTO e o retorna
     * @return MessageDTO
     */
    public MessageDTO fillDTO()
    {
        List<Message> msgList = Arrays.asList(
          Message.builder().msg("MSG 1").time(10).build(),
          Message.builder().msg("MSG 2").time(30).build()
        );
        return MessageDTO.setMessages(msgList);
    }
}
