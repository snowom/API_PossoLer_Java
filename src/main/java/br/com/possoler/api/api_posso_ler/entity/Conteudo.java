package br.com.possoler.api.api_posso_ler.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "conteudos")
@Data
public class Conteudo {
    
    @Id
    private Integer id;
    @Column(name = "qtdConteudo")
    private Long qtdConteudo;
}
