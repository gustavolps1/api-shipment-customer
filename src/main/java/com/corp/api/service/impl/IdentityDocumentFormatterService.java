package com.corp.api.service.impl;

import com.corp.api.config.ApiIdentityDocumentFormatterConfig;
import com.corp.api.dto.ApiIdentityDocumentFormatterDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class IdentityDocumentFormatterService {

    private final ApiIdentityDocumentFormatterConfig apiIdentityDocumentFormatter;

    public IdentityDocumentFormatterService(ApiIdentityDocumentFormatterConfig apiIdentityDocumentFormatter) {
        this.apiIdentityDocumentFormatter = apiIdentityDocumentFormatter;
    }

    private Map<?,?> sendServiceRequest(String... params){
        final RestTemplate restTemplate = new RestTemplate();
        final String serviceUri = apiIdentityDocumentFormatter.getURI();
        final String requestUrl = serviceUri+"?documentType=cpf&documentNumber="+params[0];
        return restTemplate.getForObject(requestUrl, Map.class);
    }

    public String format(String identityDocument) {
        final Map<?,?> serviceResponse = sendServiceRequest(identityDocument);
        String formattedDocument = "";

        if (serviceResponse != null)
            formattedDocument = (String) serviceResponse.get("document");

        ApiIdentityDocumentFormatterDTO result = ApiIdentityDocumentFormatterDTO.builder()
                .number(formattedDocument)
                .build();

        return result.getNumber();
    }
}
