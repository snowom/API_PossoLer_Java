package br.com.possoler.api.api_posso_ler.api.jornal_otempo_api.service;

import br.com.possoler.api.api_posso_ler.api.jornal_otempo_api.config.OTempoConfig;
import br.com.possoler.api.api_posso_ler.api.jornal_otempo_api.dto.OTempoDTO;
import org.springframework.stereotype.Service;

@Service
public class OTempoService {

    private final String DASHBOARD_API_URL;
    private final String COOKIE_ALLOW_CREDIT;
    private final String REST_SERVICE_TOKEN_ENCODED;

    OTempoService(OTempoConfig oTempoConfig) {
        DASHBOARD_API_URL = oTempoConfig.getDashBoardApiUrl();
        COOKIE_ALLOW_CREDIT = oTempoConfig.getCookieAllowCredit();
        REST_SERVICE_TOKEN_ENCODED = oTempoConfig.getRestServiceTokenEncoded();
    }

    /**
     * Monta e retorna objeto do DTO
     * @author thomazf
     * @return OTempoDTO
     */
    public OTempoDTO returnDTOObject()
    {
        return OTempoDTO.builder()
            .DASHBOARD_API_URL(DASHBOARD_API_URL)
            .COOKIE_ALLOW_CREDIT(COOKIE_ALLOW_CREDIT)
            .OTEMPO_REST_SERVICE_TOKEN_ENCODED(REST_SERVICE_TOKEN_ENCODED)
            .build();
    }
}
