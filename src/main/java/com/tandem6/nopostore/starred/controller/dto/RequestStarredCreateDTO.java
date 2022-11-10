package com.tandem6.nopostore.starred.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestStarredCreateDTO {
    @NotNull
    private String userId;
    @NotNull
    private String storeId;
    private Integer starred;
}
