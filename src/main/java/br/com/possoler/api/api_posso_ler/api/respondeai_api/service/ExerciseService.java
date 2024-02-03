package br.com.possoler.api.api_posso_ler.api.respondeai_api.service;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.ExerciseResponseDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.VideoResponseDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.interfaces.RespondeAiClient;
import exceptions.ServerErrorException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExerciseService {

    private final RespondeAiClient respondeAiClient;

    public ExerciseService(@Qualifier("ExerciseClient") RespondeAiClient respondeAiClient) {
        this.respondeAiClient = respondeAiClient;
    }

    public Object getExerciseData(String itemId, String token) {
        var response = respondeAiClient.getData(itemId, token);
        return buildExerciseResponse(response.toString());
    }

    private ExerciseResponseDTO buildExerciseResponse(String responseBody) {
        JSONObject jsonObject = new JSONObject(responseBody);

        var lightAnswer = buildLightAnswerResponse(jsonObject);
        var videos = buildVideoResponse(jsonObject);
        var lightSolution = buildLightSolutionResponse(jsonObject);

        return ExerciseResponseDTO.builder()
            .lightSolution(lightSolution)
            .lightAnswer(lightAnswer)
            .videos(videos)
            .build();
    }

    private List<String> buildLightSolutionResponse(JSONObject jsonObject) {
        try{
            List<String> lightSolution = new ArrayList<>();
            JSONArray lightSolutionResponse = jsonObject.getJSONArray("lightSolution");

            for(int i=0; i<lightSolutionResponse.length(); i++) {
                lightSolution.add(lightSolutionResponse.get(i).toString());
            }
            return lightSolution;
        }catch (Exception e) {
            throw new ServerErrorException("[Exercise fixation] - Falha ao obter objeto \"lightSolution\"");
        }
    }

    private String buildLightAnswerResponse(JSONObject jsonObject) {
        try{
            return jsonObject.get("lightAnswer").toString();
        }catch (Exception e) {
            throw new ServerErrorException("[Exercise] - Falha ao obter objeto \"lightAnswer\"");
        }
    }

    private List<VideoResponseDTO> buildVideoResponse(JSONObject jsonObject) {
        List<VideoResponseDTO> videos = new ArrayList<>();

        try{
            JSONArray videoResponse = (JSONArray) jsonObject.get("videos");
            for(int i=0; i<videoResponse.length(); i++) {
                videos.add(VideoResponseDTO.builder()
                .providerId((String) videoResponse.getJSONObject(i).get("providerId"))
                .provider((String) videoResponse.getJSONObject(i).get("provider"))
                .build());
            }
        }catch (Exception e) {
            throw new ServerErrorException("[Exercise] - Falha ao obter objeto \"videos\"");
        }

        return videos;
    }
}
