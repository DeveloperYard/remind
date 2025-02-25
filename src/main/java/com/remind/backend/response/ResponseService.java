package com.remind.backend.response;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {
    public <T> SingleResult<T> getSingleResult(T data){
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        setSuccessResult(result);
        return result;
    }

    public <T> ListResult<T> getListResult(List<T> list){
        ListResult<T> results = new ListResult<>();
        results.setData(list);
        setSuccessResult(results);
        return results;
    }

    public CommonResult getSuccessResult(){
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }

    public CommonResult getFailResult(CommonResponse commonResponse){
        CommonResult result = new CommonResult();
        setFailResult(commonResponse, result);
        return result;
    }

    public void setFailResult(CommonResponse commonResponse, CommonResult result){
        result.setSuccess(false);
        result.setCode(commonResponse.getCode());
        result.setMsg(commonResponse.getMsg());
    }
    public void setSuccessResult(CommonResult result){
        result.setSuccess(true);
        result.setCode(CommonResponse.SUCCESS.getCode());
        result.setMsg(CommonResponse.SUCCESS.getMsg());
    }
}
