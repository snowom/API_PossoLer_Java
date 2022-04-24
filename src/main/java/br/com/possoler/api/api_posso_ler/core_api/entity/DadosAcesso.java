package br.com.possoler.api.api_posso_ler.core_api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "dados_acesso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosAcesso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_site")
    private Site site;
    @Column
    private LocalDate data;
    @Column
    private LocalTime horario;
}
