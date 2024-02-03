package br.com.possoler.api.api_posso_ler.api.respondeai_api.service;

import br.com.possoler.api.api_posso_ler.api.respondeai_api.configs.RestConfigs;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.constants.RequestEndpoints;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.video_lesson.CoveredTopicDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.video_lesson.VideoDTO;
import br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.video_lesson.VideoLessonResponseDTO;
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

@Service("getLesson")
public class getVideoLesson extends RestConfigs implements RespondeAiConnection {

    private final String PROVIDER_JSON_PROPERTY_NAME = "provider";
    private final String PROVIDERID_JSON_PROPERTY_NAME = "providerId";
    private final String VIDEO_JSON_PROPERTY_NAME = "video";
    private final String VIDEO_NAME_PROPERTY_NAME = "name";
    private final String COVERED_TOPIC_PROPERTY_NAME = "coveredTopics";
    private final String LECTURE_MODULES_PROPERTY_NAME = "lectureModules";
    private final String COVERED_TOPIC_FIRST_EXERCISE_ID_PROPERTY_NAME = "firstExerciseId";
    private final String COVERED_TOPIC_ID_PROPERTY_NAME = "id";
    private final String COVERED_TOPIC_NAME_PROPERTY_NAME = "name";
    private final String COVERED_TOPIC_SUBJECT_ID_PROPERTY_NAME = "subjectId";
    private final String COVERED_TOPIC_THEORY_ID_PROPERTY_NAME = "theoryId";

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

    private List<VideoLessonResponseDTO> buildVideoLeassonResponse(String responseBody) {
        var videosResponse = new ArrayList<VideoLessonResponseDTO>();
        var jsonObject = new JSONObject(responseBody);

        try{
            var lectureModes = (JSONArray) jsonObject.get(LECTURE_MODULES_PROPERTY_NAME);

            for(int i=0; i< lectureModes.length(); i++) {
                var coveredTopicArray = lectureModes.getJSONObject(i);
                var coveredTopics = buildCoveredTopicsResponse(coveredTopicArray);
                var video = buildVideoResponse(lectureModes.getJSONObject(i));

                videosResponse.add(
                    VideoLessonResponseDTO.builder()
                        .video(video)
                        .coveredTopics(coveredTopics)
                        .build()
                );
            }
            return videosResponse;

        }catch(Exception e) {
            throw new ServerErrorException("[Video Leassons] - Falha ao montar objeto \"VideoLessonResponse\"");
        }
    }

    private VideoDTO buildVideoResponse(JSONObject jsonArrayObject) {
        try{
            var videoName = jsonArrayObject.get(VIDEO_NAME_PROPERTY_NAME).toString();
            var video = jsonArrayObject.getJSONObject(VIDEO_JSON_PROPERTY_NAME);
            var videoProvider = video.get(PROVIDER_JSON_PROPERTY_NAME).toString();
            var videoProviderId = video.get(PROVIDERID_JSON_PROPERTY_NAME).toString();

            return VideoDTO.builder()
                .name(videoName)
                .provider(videoProvider)
                .providerId(videoProviderId)
                .build();

        }catch(Exception e){
            throw new ServerErrorException("[Video Leassons] - Falha ao montar objeto \"videos\"");
        }
    }

    private List<CoveredTopicDTO> buildCoveredTopicsResponse(JSONObject jsonObject) {
        var coveredTopics = new ArrayList<CoveredTopicDTO>();
        var coveredTopicsArray = (JSONArray) jsonObject.get(COVERED_TOPIC_PROPERTY_NAME);

        try{
            for(int i=0; i<coveredTopicsArray.length(); i++) {
                var currentCoveredTopic = coveredTopicsArray.getJSONObject(i);

                var firstExerciseId = currentCoveredTopic.get(COVERED_TOPIC_FIRST_EXERCISE_ID_PROPERTY_NAME).toString();
                var id = currentCoveredTopic.get(COVERED_TOPIC_ID_PROPERTY_NAME).toString();
                var name = currentCoveredTopic.get(COVERED_TOPIC_NAME_PROPERTY_NAME).toString();
                var subjectId = currentCoveredTopic.get(COVERED_TOPIC_SUBJECT_ID_PROPERTY_NAME).toString();
                var theoryId = currentCoveredTopic.get(COVERED_TOPIC_THEORY_ID_PROPERTY_NAME).toString();

                coveredTopics.add(
                    CoveredTopicDTO.builder()
                        .id(id)
                        .name(name)
                        .firstExerciseId(firstExerciseId)
                        .subjectId(subjectId)
                        .theoryId(theoryId)
                        .build()
                );
            }
            return coveredTopics;
        }catch(Exception e){
            throw new ServerErrorException("[Video Leassons] - Falha ao montar objeto \"coverageTopic\"");
        }
    }

    @Override
    public String buildURIRequest(String exerciseId) {
        return RequestEndpoints.DOMAIN_REQUEST + RequestEndpoints.VIDEO_LEASSON_ENDPOINT_REQUEST + exerciseId;
    }
}
