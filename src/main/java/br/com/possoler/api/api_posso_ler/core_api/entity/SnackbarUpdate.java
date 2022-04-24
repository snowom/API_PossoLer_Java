package br.com.possoler.api.api_posso_ler.core_api.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SnackbarUpdate {
    
    String currentVersion;
    String message;
    String buttonMessage;
    Integer time;
}
