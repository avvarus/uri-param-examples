package com.home.uriparamexamples.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
public class InvalidCountryException extends RuntimeException {

    @Setter
    @Getter
    private String message;

}
