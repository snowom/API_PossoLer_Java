package br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.video_lesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class VideoLessonResponseDTO {
    private VideoDTO video;
    private List<CoveredTopicDTO> coveredTopics;
}
