package br.com.possoler.api.api_posso_ler.api.core_api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.possoler.api.api_posso_ler.api.core_api.model.DadosAcesso;
import br.com.possoler.api.api_posso_ler.api.core_api.model.Site;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DadosAcessoDTO {
    
    @NotNull(message = "O campo 'codigo_site' não pode ser vazio")
    @Min(value = 1, message = "Jornal invalido")
    @Max(value = 38, message = "Jornal invalido")
    private Integer codigo_site;
    @NotNull(message = "O campo 'data' não pode ser vazio")
    private LocalDate data;
    @NotNull(message = "O campo 'horario' não pode ser vazio")
    private LocalTime horario;


    public static DadosAcesso parseToEntity(DadosAcessoDTO dto, Site site)
    {
        return DadosAcesso.builder()
            .site(site)
            .data(dto.getData())
            .horario(dto.getHorario())
            .build();
    }
}
