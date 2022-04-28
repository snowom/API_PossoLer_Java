package br.com.possoler.api.api_posso_ler.cachemock_api.controller;

import br.com.possoler.api.api_posso_ler.cachemock_api.dto.PostModelDTO;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.PostModelEntity;
import br.com.possoler.api.api_posso_ler.cachemock_api.service.CachemockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CachemockController {

    @Autowired
    private CachemockService cachemockService;
    @Autowired
    private Environment env;

    @PostMapping("${cachemock-api.endpoint.cachemock}")
    private ResponseEntity<?> getArticleContent(
            @RequestParam(value = "options", required = true) String options,
            @RequestBody PostModelEntity postModel,
            UriComponentsBuilder uriBuilder
    ){
        Map<String, String> response = new HashMap<>();
        if(options.equals("post")){
            Boolean isCreated = cachemockService.createUnlockedFile(postModel);
            if (isCreated) response.put("response", "success");
            URI uri = uriBuilder.path(this.env.getProperty("cachemock-api.endpoint.cachemock")).build().toUri();
            return ResponseEntity.created(uri).body(response);
        }
        else if(options.equals("get")){
            if(cachemockService.checkGetBodyParams(postModel.getKey())){
                PostModelDTO responseObject = cachemockService.getUnlockedFileContent(postModel.getKey());
                return ResponseEntity.ok().body(responseObject);
            }
        }
        response.put("message", "operação inválida");
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping("${cachemock-api.endpoint.getQuantityFilesUnlocked}")
    private ResponseEntity<Map<String, Integer>> getUnlockedFilesQuantity()
    {
        Map<String, Integer> response = new HashMap<>();
        Integer files = cachemockService.getUnlockedFilesQuantity();
        response.put("qtd arquivos", files);
        return ResponseEntity.ok().body(response);
    }


    @GetMapping("${cachemock-api.endpoint.clearUnlockedFiles}")
    private ResponseEntity<Map<String, String>> clearUnlockedFiles()
    {
        Map<String, String> response = new HashMap<>();
        cachemockService.clearUnlockedFiles();
        response.put("sucesso","arquivos limpos");
        return ResponseEntity.ok().body(response);
    }
}
