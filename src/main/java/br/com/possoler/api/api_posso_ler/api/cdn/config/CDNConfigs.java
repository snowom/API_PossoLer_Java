package br.com.possoler.api.api_posso_ler.api.cdn.config;

import br.com.possoler.api.api_posso_ler.api.utils.PathConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CDNConfigs {

    @Autowired
    private Environment environment;

    @Bean
    public String setCDNPath() {
        var scope = environment.getProperty("SCOPE");
        return (scope == null)
            ? System.getProperty("user.dir") + PathConstants.FOLDER_POSSOLER_INTEGRATOR + "/CDN/"
            : System.getProperty("user.dir") + "\\src\\main\\resources\\static\\CDN\\";
    }

    @Bean
    public Map<String, String> createCDNFilesMap() {
        Map<String, String> files = new HashMap<>();
        files.put("blockCorePaywall", "[FF]blockCorePaywall.js");
        files.put("snackjs", "snackbar.js");
        files.put("snackcss", "snackbar.css");
        files.put("axioslogo", "img/axiosJS.png");
        files.put("mavenlogo", "img/maven.png");
        files.put("lomboklogo", "img/lombok.png");
        files.put("springlogo", "img/spring.png");
        files.put("possolerlogo", "img/128.png");
        files.put("respondeailogo", "img/respai.png");
        files.put("glidejs", "glide.min.js");
        files.put("glidecorecss", "glide.core.min.css");
        files.put("glidethemecss", "glide.theme.min.css");
        files.put("app_respondeai", "extension/app_responde_ai/app_respondeai.js");
        files.put("respondeai", "extension/responde_ai/respondeai.js");
        files.put("valorecon", "extension/valor_economico/valor_economico.js");
        files.put("exame", "extension/exame/exame.js");
        files.put("jota", "extension/jota/jota.js");
        files.put("nytimes", "extension/nytimes/nytimes.js");
        files.put("elpais", "extension/elpais/elpais.js");
        files.put("gauchazh", "extension/gauchazh/gauchazh.js");
        files.put("opopular", "extension/opopular/opopular.js");
        files.put("diariosm", "extension/diariosm/diariosm.js");
        files.put("otempomg", "extension/otempomg/otempomg.js");
        files.put("jornaldocomercio", "extension/jornaldocomercio/jornaldocomercio.js");
        files.put("opovo", "extension/opovo/opovo.js");
        files.put("gaz", "extension/gaz/gaz.js");
        files.put("possoler", "extension/possoler/possoler.js");
        files.put("att_versao", "extension/att_versao/att_versao.js");
        files.put("check_messages", "extension/check_messages/check_messages.js");
        files.put("count_content", "extension/count_content/count_content.js");
        files.put("save_site_access", "extension/save_site_access/save_site_access.js");
        files.put("block_request", "extension/block_request/block_request.js");

        return files;
    }
}
