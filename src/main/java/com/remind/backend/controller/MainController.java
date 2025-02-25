package com.remind.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {
    @RequestMapping(value="/v1/hello", method= RequestMethod.GET)
    @Operation(summary="사용자 조회", description = "ID를 이용해 사용자 조회",
        responses = {
            @ApiResponse(responseCode="200", description = "success"),
            @ApiResponse(responseCode = "400", description = "failed request")
        }
    )
    public String hello(){
        return "hello";
    }
}
