package br.com.possoler.api.api_posso_ler.api.cdn.service;

import br.com.possoler.api.api_posso_ler.api.cdn.constants.CDNEnum;
import exceptions.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class CDNFileService {

    @Autowired
    private HttpServletResponse response;
    private final String CDN_PATH = System.getProperty("user.dir") + "\\api_posso_ler\\src\\main\\resources\\static\\CDN\\";

    public void downloadCdnFile(String fileParamName) throws IOException, NotFoundException {
        String filename = this.getFileName(fileParamName);
        File file = new File(this.CDN_PATH + filename);
        FileInputStream inputStream = new FileInputStream(file);
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
        throw new NotFoundException("Arquivo CDN não encontrado");
    }
}
