package com.example.uni_jpa_sec.controllers;

import com.example.uni_jpa_sec.apiUtils.NoSuchElementFoundException;
import com.example.uni_jpa_sec.dtos.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionController extends RuntimeException{

    @ResponseBody
    @ExceptionHandler(NoSuchElementFoundException.class)
    public ApiResponse handelUnexpectedException(NoSuchElementFoundException e){
        ApiResponse apiResponse = new ApiResponse();
      //  apiResponse.addData("error", e.getMessage());
        apiResponse.addError("error", e.getMessage());
        return apiResponse;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse handelUnexpectedException(Exception e){
        ApiResponse apiResponse = new ApiResponse();
    //    apiResponse.addData("unknown", e.getMessage());
        apiResponse.addError("unknown", e.getMessage());
        return apiResponse;
    }

}
