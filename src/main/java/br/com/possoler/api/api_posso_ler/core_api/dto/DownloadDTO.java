package br.com.possoler.api.api_posso_ler.core_api.dto;

import br.com.possoler.api.api_posso_ler.core_api.entity.Download;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DownloadDTO {
    
    private Integer qtdDownloads;

    public static DownloadDTO parseToDTO(Download download)
    {
        return DownloadDTO.builder()
            .qtdDownloads(download.getQtd())
            .build();
    }
}
