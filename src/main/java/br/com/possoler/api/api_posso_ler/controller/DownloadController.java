package br.com.possoler.api.api_posso_ler.controller;

import java.util.HashMap;
import java.util.Map;

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


    @GetMapping("/incrementDownloads")
    private ResponseEntity<Map<String, String>> incrementDownloads()
    {
        Map<String, String> response = new HashMap<>();
        Boolean status = downloadService.incrementDownload();
        if(status){
            response.put("status", "sucesso");
            return ResponseEntity.ok().body(response);
        }
        response.put("status", "falha");
        return ResponseEntity.internalServerError().body(response);
    }
}
