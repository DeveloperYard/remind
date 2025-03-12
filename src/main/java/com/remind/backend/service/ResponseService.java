package com.remind.backend.service;

import com.remind.backend.model.CommonResult;
import com.remind.backend.model.ListResult;
import com.remind.backend.model.SingleResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    // 성공 응답 (단일 데이터)
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    // 성공 응답 (리스트 데이터)
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setData(list);
        setSuccessResult(result);
        return result;
    }

    // 실패 응답 (에러 메시지 포함)
    public CommonResult getFailResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    // 성공 설정 공통 메서드
    private void setSuccessResult(CommonResult result) {
        result.setSuccess(true);
        result.setCode(0);
        result.setMessage("Success");
    }
}
