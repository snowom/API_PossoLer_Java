package br.com.possoler.api.api_posso_ler.api.core_api.service;

import exceptions.NotFoundException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class DownloadExtensionService {

    @Autowired
    private HttpServletResponse response;
    private final String EXTENSION_PATH = "\\extension\\";

    public void downloadExtension(String filename) throws IOException {
        this.configServletResponse(this.response, filename);
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(this.EXTENSION_PATH + filename);
        if(inputStream == null) {
            throw new NotFoundException("falha ao localizar arquivo no servidor");
        }
        IOUtils.copy(inputStream, this.response.getOutputStream());
        this.response.flushBuffer();
    }

    private void configServletResponse(HttpServletResponse response, String filename) {
        response.setContentType("application/octet-stream");
        response.setHeader(
            "Content-Disposition",
            "attachment;filename=" + filename
        );
    }
}
