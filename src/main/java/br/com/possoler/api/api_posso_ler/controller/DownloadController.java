package br.com.possoler.api.api_posso_ler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.possoler.api.api_posso_ler.dto.DownloadDTO;
import br.com.possoler.api.api_posso_ler.entity.Download;
import br.com.possoler.api.api_posso_ler.service.DownloadService;

@RestController
@RequestMapping("/API")
public class DownloadController {
    
    @Autowired
    DownloadService downloadService;

    @GetMapping("/getDownloads")
    private ResponseEntity<DownloadDTO> getDownloads()
    {
        Download download = downloadService.getDownloadEntity();
        return ResponseEntity.ok().body(DownloadDTO.parseToDTO(download));
    }
}
