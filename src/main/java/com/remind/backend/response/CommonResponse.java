package com.remind.backend.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponse {
    SUCCESS(0, "success"),
    FAIL(1, "failed");

    private final int code;
    private final String msg;
}
