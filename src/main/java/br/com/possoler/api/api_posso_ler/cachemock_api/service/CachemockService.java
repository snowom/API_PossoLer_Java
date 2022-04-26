package br.com.possoler.api.api_posso_ler.cachemock_api.service;

import br.com.possoler.api.api_posso_ler.cachemock_api.dto.PostModelDTO;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.GetModelEntity;
import br.com.possoler.api.api_posso_ler.cachemock_api.entity.PostModelEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ClientErrorException;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;

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
            if(this.checkPostBodyParameters(postModel)){
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(new File(this.RESOURCES_PATH + postModel.getKey()), PostModelDTO.parseToDTO(postModel));
                return true;
            }
            return false;
        } catch (IOException | ClientErrorException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Verifica se os campos do payload esta correto
     * @author thomazf
     * @param postModel
     * @return Boolean
     * @throws ClientErrorException
     */
    private Boolean checkPostBodyParameters(PostModelEntity postModel) throws ClientErrorException {
        if(postModel.getKey() == null || postModel.getKey().length() == 0)
            throw new ClientErrorException("O parâmetro \"key\" não pode ser nulo ou vazio");
        if(postModel.getPageSource() == null || postModel.getPageSource().length() == 0)
            throw new ClientErrorException("O parâmetro \"pageSource\" não pode ser nulo ou vazio");
        return true;
    }


    /**
     * Retorna JSON do arquivo solicitado
     * @author thomazf
     * @param key
     * @return PostModelDTO
     */
    public PostModelDTO getUnlockedFileContent(String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(this.RESOURCES_PATH + key), PostModelDTO.class);
        } catch (IOException | RuntimeException e) {
            throw new ClientErrorException(e.getMessage());
        }
    }

    /**
     * Valida payload
     * @author thomazf
     * @param key
     * @return Boolean
     */
    public Boolean checkGetBodyParams(String key)
    {
        if(key.length() == 0)
            throw new ClientErrorException("O parâmetro \"key\" não pode ser nulo ou vazio");
        return true;
    }
}
