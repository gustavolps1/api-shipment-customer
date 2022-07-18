package com.corp.api.controller.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PingResponse {
    private String message;
}
