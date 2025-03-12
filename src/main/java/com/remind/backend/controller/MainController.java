package com.remind.backend.controller;

import com.remind.backend.exception.CustomExceptionForTest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Email;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
public class MainController {
    @RequestMapping(value="/v1/npe-test", method= RequestMethod.GET)
    @Operation(summary="사용자 조회", description = "ID를 이용해 사용자 조회",
        responses = {
            @ApiResponse(responseCode="200", description = "success"),
            @ApiResponse(responseCode="1000", description = "custom error."),
            @ApiResponse(responseCode = "400", description = "failed request")
        }
    )
    public String hello(@RequestParam String name){
        if(name.equals("sw")){
            throw new NullPointerException();// null pointer 던지는 것 확인 완료
        }
        return "hello";
    }
    @RequestMapping(value="/v1/aop-test", method= RequestMethod.GET)
    @Operation(summary = "aop 테스트", description = "이게 될까?",
        responses = {
                @ApiResponse(responseCode="200", description = "success"),
                @ApiResponse(responseCode="1000", description = "custom error."),
                @ApiResponse(responseCode = "400", description = "failed request")
        }
    )
    public String bye(@RequestParam String name){
        if(name.equals("sw")){
            throw new CustomExceptionForTest("customException");// null pointer 던지는 것 확인 완료
        }
        return "hello";
    }

    @RequestMapping(value="/v1/custom-test", method = RequestMethod.GET)
    @Operation(summary = "커스텀 예외 테스트", description = "이게 될까?",
            responses = {
                    @ApiResponse(responseCode="200", description = "success"),
                    @ApiResponse(responseCode="1000", description = "custom error."),
                    @ApiResponse(responseCode = "400", description = "failed request")
            }
    )
    public String customTest(@RequestParam(required = true) @Email String uid){
        return "hi";
    }
}
