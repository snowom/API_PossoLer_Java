package br.com.possoler.api.api_posso_ler.api.cdn.service;

import br.com.possoler.api.api_posso_ler.api.cdn.config.CDNConfigs;
import exceptions.NotFoundException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CDNFileService {

    @Autowired
    private HttpServletResponse response;
    private final String CDN_PATH;
    private final Map<String, String> files;

    public CDNFileService(CDNConfigs cdnConfigs) {
        CDN_PATH = cdnConfigs.setCDNPath();
        files = cdnConfigs.createCDNFilesMap();
    }

    public void readCdnFile(String fileParamName) throws IOException, NotFoundException {
        String filepath = getFilepath(fileParamName);
        File file = new File(CDN_PATH + filepath);
        FileInputStream inputStream = new FileInputStream(file);
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

    private String getFilepath(String fileAlias) {
        var filepath = files.get(fileAlias);
        if(filepath == null) {
            throw new NotFoundException("Arquivo CDN não encontrado");
        }
        return filepath;
    }
}