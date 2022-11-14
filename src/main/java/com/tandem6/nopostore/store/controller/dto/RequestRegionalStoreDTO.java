package com.tandem6.nopostore.store.controller.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class RequestRegionalStoreDTO implements Serializable {

    @NotNull
    private String location;

}
