package br.com.possoler.api.api_posso_ler.api.signUser.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckUserDTO {
    @NotNull(message = "O parametro 'userHash' não deve ser nulo")
    @Length(min = 64, max = 64, message = "Hash inválido")
    private String userHash;
}
