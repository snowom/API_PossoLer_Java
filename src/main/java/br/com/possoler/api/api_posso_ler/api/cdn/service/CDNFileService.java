package br.com.possoler.api.api_posso_ler.api.cdn.service;

import br.com.possoler.api.api_posso_ler.api.cdn.constants.CDNEnum;
import exceptions.NotFoundException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@Service
public class CDNFileService {

    @Autowired
    private HttpServletResponse response;

    public void readCdnFile(String fileParamName) throws IOException, NotFoundException {
        String filename = this.getFileName(fileParamName);
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        if(inputStream == null) {
            throw new NotFoundException("falha ao localizar arquivo no servidor");
        }
        IOUtils.copy(inputStream, this.response.getOutputStream());
        this.response.flushBuffer();
    }

    private String getFileName(String file) {
        if(file.equalsIgnoreCase(CDNEnum.BLOCK_CORE_PAYWALL.getFileParamName())) {
            return CDNEnum.BLOCK_CORE_PAYWALL.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.SNACKBAR_JS.getFileParamName())) {
            return CDNEnum.SNACKBAR_JS.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.SNACKBAR_CSS.getFileParamName())) {
            return CDNEnum.SNACKBAR_CSS.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.POSSOLER_LOGO.getFileParamName())) {
            return CDNEnum.POSSOLER_LOGO.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.AXIOS_LOGO.getFileParamName())) {
            return CDNEnum.AXIOS_LOGO.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.MAVEN_LOGO.getFileParamName())) {
            return CDNEnum.MAVEN_LOGO.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.LOMBOK_LOGO.getFileParamName())) {
            return CDNEnum.LOMBOK_LOGO.getFilename();
        }
        if(file.equalsIgnoreCase(CDNEnum.SPRING_LOGO.getFileParamName())) {
            return CDNEnum.SPRING_LOGO.getFilename();
        }
        throw new NotFoundException("Arquivo CDN não encontrado");
    }
}
