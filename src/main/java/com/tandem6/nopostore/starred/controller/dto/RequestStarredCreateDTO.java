package com.tandem6.nopostore.starred.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class RequestStarredCreateDTO implements Serializable {
    @NotNull(message = "UserId cannot be null")
    private String userId;
    @NotNull
    private String storeId;
    @Max(5)
    private Integer starred;
}
