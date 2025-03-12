package com.remind.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
        private boolean success;
        private int code;
        private String message;
}
