package br.com.possoler.api.api_posso_ler.api.core_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "sites")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Site {
    
    @Id
    private Integer id;
    @Column
    private String nome;
    @Column
    private String corTema;
}
