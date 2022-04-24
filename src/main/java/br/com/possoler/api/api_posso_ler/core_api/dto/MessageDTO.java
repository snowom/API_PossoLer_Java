package br.com.possoler.api.api_posso_ler.core_api.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.possoler.api.api_posso_ler.core_api.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    
    private List<Message> messages;

    public static MessageDTO setMessages(List<Message> messageList)
    {
        List<Message> lista = new ArrayList<>();
        for (Message message : messageList) {
            lista.add(message);
        }
        return MessageDTO.builder().messages(lista).build(); 
    }
}
