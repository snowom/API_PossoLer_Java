package br.com.possoler.api.api_posso_ler.api.respondeai_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookExerciseResponseEntity {

    private String id;
    private String lightBody;
    private List<String> lightSolution;
    private String lightAnswer;
    private Object topic;
}
