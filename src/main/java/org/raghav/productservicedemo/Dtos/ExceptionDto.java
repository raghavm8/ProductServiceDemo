package org.raghav.productservicedemo.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDto {
    private String message;
    private String errorCode;
}
