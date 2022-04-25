package br.com.possoler.api.api_posso_ler.cachemock_api.controller;

import br.com.possoler.api.api_posso_ler.cachemock_api.dto.PostModelDTO;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.GetModelEntity;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.PostModelEntity;
import br.com.possoler.api.api_posso_ler.cachemock_api.service.CachemockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
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
        }else if(options.equals("get")){
            GetModelEntity getModelEntity = GetModelEntity.builder().key(postModel.getKey()).build();
            PostModelDTO responseObject = cachemockService.getUnlockedFileContent(getModelEntity);
            return ResponseEntity.ok().body(responseObject);
        }
        response.put("message", "operação inválida");
        return ResponseEntity.badRequest().body(response);
    }
}
