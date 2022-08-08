package com.corp.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "integration.services.api-identity-document-formatter")
public class ApiIdentityDocumentFormatterConfig {

    private String host;

    private String resource;

    public String getURI(){
        return host + resource;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
