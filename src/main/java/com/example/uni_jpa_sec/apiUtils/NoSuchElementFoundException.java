package com.example.uni_jpa_sec.apiUtils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends RuntimeException{

    private static final String NO_SUCH_ELEMENT_EXCEPTION="NO_SUCH_ELEMENT_EXCEPTION";

    private Map<String,Object> description = new HashMap<>();

    public NoSuchElementFoundException() {
        super(NO_SUCH_ELEMENT_EXCEPTION);
    }

    public NoSuchElementFoundException addDescription(String key, Object value) {
        this.description.put(key, value);

        return this;
    }
}
