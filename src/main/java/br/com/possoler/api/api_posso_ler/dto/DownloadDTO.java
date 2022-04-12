package br.com.possoler.api.api_posso_ler.dto;

import br.com.possoler.api.api_posso_ler.entity.Download;
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
