package br.com.possoler.api.api_posso_ler.api.respondeai_api.service;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.TheoryResponseDTO;
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
public class TheoryService {

    private final RespondeAiClient respondeAiClient;

    public TheoryService(@Qualifier("TheoryClient") RespondeAiClient respondeAiClient) {
        this.respondeAiClient = respondeAiClient;
    }

    public Object getTheoryData(String itemId, String token) {
        var response = respondeAiClient.getData(itemId, token);
        return buildTheoryResponse(response.toString());
    }

    private TheoryResponseDTO buildTheoryResponse(String responseBody) {
        var jsonObject = new JSONObject(responseBody);
        var lightBody = buildLightBodyResponse(jsonObject);
        var videos = buildVideoResponse(jsonObject);

        return TheoryResponseDTO.builder()
            .lightBody(lightBody)
            .videos(videos)
            .build();
    }

    private String buildLightBodyResponse(JSONObject jsonObject) {
        try{
            return jsonObject.get("lightBody").toString();
        }catch (Exception e) {
            throw new ServerErrorException("[Theory] - Falha ao obter objeto \"lightBody\"");
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
            throw new ServerErrorException("[Theory] - Falha ao obter objeto \"videos\"");
        }

        return videos;
    }
}
