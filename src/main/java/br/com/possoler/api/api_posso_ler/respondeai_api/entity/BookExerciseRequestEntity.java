package br.com.possoler.api.api_posso_ler.respondeai_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookExerciseRequestEntity {

    private String operationName;
    private String query;
    private Variables variables;
}
