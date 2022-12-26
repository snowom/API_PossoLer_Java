package br.com.possoler.api.api_posso_ler.api.core_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "conteudos")
@Data
public class Conteudo {
    
    @Id
    private Integer id;
    @Column(name = "qtdConteudo")
    private Long qtdConteudo;
}
