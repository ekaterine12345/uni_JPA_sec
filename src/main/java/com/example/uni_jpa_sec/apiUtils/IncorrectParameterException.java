package com.example.uni_jpa_sec.apiUtils;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IncorrectParameterException {

    @Getter
    private Set<String> incorrectParameters = new HashSet<>();

    public IncorrectParameterException(String parameter) {
        this.incorrectParameters.add(parameter);
    }

    public IncorrectParameterException(String... parameters) {
        Set<String> collect = Arrays.
                stream(parameters)
                .collect(Collectors.toSet());

        this.incorrectParameters.addAll(collect);
    }
}
