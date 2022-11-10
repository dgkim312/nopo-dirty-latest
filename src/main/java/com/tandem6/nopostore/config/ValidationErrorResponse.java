package com.tandem6.nopostore.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ValidationErrorResponse implements Serializable {
    private String errorMessage;
    private String requestDescription;
}
