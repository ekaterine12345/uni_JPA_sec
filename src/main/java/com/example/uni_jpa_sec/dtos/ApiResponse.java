package com.example.uni_jpa_sec.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class ApiResponse {
    private Map<String, Object> data = new HashMap<>();
    private Map<String, Object> errors = new HashMap<>();

    public ApiResponse(String key, Object value) {
        this.data.put(key, value);
    }

    public ApiResponse addData(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public ApiResponse addError(String key, Object value){
        this.errors.put(key, value);
        return this;
    }
}
