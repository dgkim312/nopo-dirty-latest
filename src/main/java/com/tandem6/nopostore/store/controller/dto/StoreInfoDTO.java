package com.tandem6.nopostore.store.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreInfoDTO {
    private String managementNo;
    private String licenseIssueDate;
    private String storeName;
    private String locationAddress;
    private String businessType;
    private Float ranking;
}
