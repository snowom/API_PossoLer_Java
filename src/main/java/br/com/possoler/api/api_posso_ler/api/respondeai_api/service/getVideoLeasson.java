package br.com.possoler.api.api_posso_ler.api.respondeai_api.service;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.configs.RestConfigs;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.constants.RequestEndpoints;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.VideoResponseDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.interfaces.RespondeAiConnection;
import exceptions.ServerErrorException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("getLeasson")
public class getVideoLeasson extends RestConfigs implements RespondeAiConnection {

    @Override
    public Object getData(String itemId, String token) {
        HttpHeaders header = setHeaders(token);
        final String URI = buildURIRequest(itemId);

        httpMethod = HttpMethod.GET;
        entity = new HttpEntity<>(header);
        response = restTemplate.exchange(URI, httpMethod, entity, String.class);

        validateResponse(response);
        var responseBody = response.getBody();
        var response = buildVideoLeassonResponse(responseBody);
        return response;
    }

    private List<VideoResponseDTO> buildVideoLeassonResponse(String responseBody) {
        List<VideoResponseDTO> videosResponse = new ArrayList<>();
        var jsonObject = new JSONObject(responseBody);

        try{
            var lectureModes = (JSONArray) jsonObject.get("lectureModules");

            for(int i=0; i<lectureModes.length(); i++) {
                var video = lectureModes.getJSONObject(i).getJSONObject("video");
                var videoResponse = VideoResponseDTO.builder()
                        .provider(video.get("provider").toString())
                        .providerId(video.get("providerId").toString())
                        .build();
                videosResponse.add(videoResponse);
            }
        }catch(Exception e) {
            throw new ServerErrorException("[Video Leassons] - Falha ao obter objeto \"videos\"");
        }

        return videosResponse;
    }

    @Override
    public String buildURIRequest(String exerciseId) {
        return RequestEndpoints.DOMAIN_REQUEST + RequestEndpoints.VIDEO_LEASSON_ENDPOINT_REQUEST + exerciseId;
    }
}
