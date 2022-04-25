package br.com.possoler.api.api_posso_ler.cachemock_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostModelEntity {

    private String key;
    private String pageSource;
}
