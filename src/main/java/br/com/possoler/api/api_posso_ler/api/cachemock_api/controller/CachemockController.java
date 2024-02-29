package br.com.possoler.api.api_posso_ler.api.cachemock_api.controller;

import br.com.possoler.api.api_posso_ler.api.cachemock_api.config.CachemockConfig;
import br.com.possoler.api.api_posso_ler.api.cachemock_api.dto.PostModelDTO;
import br.com.possoler.api.api_posso_ler.api.cachemock_api.model.GetArticleEntity;
import br.com.possoler.api.api_posso_ler.api.cachemock_api.model.PostArticleEntity;
import br.com.possoler.api.api_posso_ler.api.cachemock_api.service.CachemockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CachemockController {

    private final CachemockService cachemockService;
    private final String ARTICLE_CONTENT_ROUTE;

    CachemockController(CachemockService cachemockService, CachemockConfig cacheMockConfig) {
        this.cachemockService = cachemockService;
        ARTICLE_CONTENT_ROUTE = cacheMockConfig.getArticleContentRoute();
    }

    @PostMapping("${cachemock-api.endpoint.saveArticleContent}")
    private ResponseEntity<?> saveArticleContent(
            @RequestBody PostArticleEntity postModel,
            UriComponentsBuilder uriBuilder
    ){
        Map<String, String> response = new HashMap<>();
        Boolean isCreated = this.cachemockService.createUnlockedFile(postModel);
        if (isCreated) response.put("response", "success");
        URI uri = uriBuilder.path(ARTICLE_CONTENT_ROUTE).build().toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("${cachemock-api.endpoint.getArticleContent}")
    private ResponseEntity<?> getArticleContent(@RequestBody GetArticleEntity getArticleEntity) {
        Map<String, String> response = new HashMap<>();
        this.cachemockService.checkValidKey(getArticleEntity.getKey());
        PostModelDTO responseObject = this.cachemockService.getUnlockedFileContent(getArticleEntity.getKey());
        return ResponseEntity.ok().body(responseObject);
    }

    @GetMapping("${cachemock-api.endpoint.getQuantityFilesUnlocked}")
    private ResponseEntity<Map<String, Integer>> getUnlockedFilesQuantity()
    {
        Map<String, Integer> response = new HashMap<>();
        Integer files = cachemockService.getUnlockedFilesQuantity();
        response.put("qtd_arquivos", files);
        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("${cachemock-api.endpoint.clearUnlockedFiles}")
    private ResponseEntity<Map<String, String>> clearUnlockedFiles(
        @RequestHeader(name = "authorization") String authHeader
    )
    {
        Map<String, String> response = new HashMap<>();
        if(this.cachemockService.isValidAuthorizationHeader(authHeader)) {
            cachemockService.clearUnlockedFiles();
            response.put("message","arquivos limpos");
            return ResponseEntity.ok().body(response);
        }
        response.put("message","não autorizado");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}
