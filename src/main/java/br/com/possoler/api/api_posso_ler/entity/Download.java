package br.com.possoler.api.api_posso_ler.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "downloads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Download {
    
    @Id
    private Integer id;
    private Integer qtd;
}
