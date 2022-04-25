package br.com.possoler.api.api_posso_ler.cachemock_api.service;

import br.com.possoler.api.api_posso_ler.cachemock_api.dto.PostModelDTO;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.GetModelEntity;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.PostModelEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import exceptions.ClientErrorException;
import exceptions.ServerErrorException;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class CachemockService {

    private final String RESOURCES_PATH = System.getProperty("user.dir") + "\\api_posso_ler\\src\\main\\resources\\cachemock\\jsonFiles\\";

    /**
     * Cria arquivo JSON com conteudo da pagina desbloqueada
     * @author thomazf
     * @param postModel
     * @return Boolean
     */
    public Boolean createUnlockedFile(PostModelEntity postModel)
    {
        try {
            if(this.checkPostBodyParamters(postModel)){
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(new File(this.RESOURCES_PATH + postModel.getKey()), PostModelDTO.parseToDTO(postModel));
                return true;
            }
            return false;
        } catch (IOException | ClientErrorException e) {
            throw new RuntimeException(e);
        }
    }


    private Boolean checkPostBodyParamters(PostModelEntity postModel) throws ClientErrorException {
        if(postModel.getPageSource() == null || postModel.getPageSource().length() == 0)
            throw new ClientErrorException("O parâmetro \"pageSource\" não pode ser nulo ou vazio");
        if(postModel.getKey() == null || postModel.getKey().length() == 0)
            throw new ClientErrorException("O parâmetro \"key\" não pode ser nulo ou vazio");
        return true;
    }

    public PostModelDTO getUnlockedFileContent(GetModelEntity getModel) {
        try{
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(this.RESOURCES_PATH + getModel.getKey()), PostModelDTO.class);
        }catch(IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
