package com.corp.api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerDTO {
    private String id;
    private String name;
    private String identityDocument;
}
