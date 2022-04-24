package br.com.possoler.api.api_posso_ler.core_api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
