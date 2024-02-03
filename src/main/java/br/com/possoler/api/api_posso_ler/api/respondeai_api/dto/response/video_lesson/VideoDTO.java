package br.com.possoler.api.api_posso_ler.api.respondeai_api.dto.response.video_lesson;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoDTO {
    private String provider;
    private String providerId;
    private String name;
}
