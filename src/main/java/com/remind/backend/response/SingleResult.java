package com.remind.backend.response;


import lombok.Data;

@Data
public class SingleResult<T> extends CommonResult{
    private T data;
}
