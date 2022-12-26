package br.com.possoler.api.api_posso_ler.api.core_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
