package com.corp.api.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
public class IdentityDocumentFormatterService {

    public String format(String identityDocument) {
        final String URI_API_IDENTITY_DOCUMENT_FORMATTER = "http://localhost:8080/api-identity-document-formatter?documentType=cpf&documentNumber="+identityDocument;
        RestTemplate restTemplate = new RestTemplate();
        Map<?, ?> result = restTemplate.getForObject(URI_API_IDENTITY_DOCUMENT_FORMATTER, Map.class);
        log.info("api-identity-document-formatter -> "+result);
        return (String) result.get("document");
    }
}
