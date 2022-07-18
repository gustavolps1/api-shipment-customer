package com.corp.api.controller.response;

import com.corp.api.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerResponse {

    @JsonProperty("customer")
    private CustomerDTO customerDTO;
}
