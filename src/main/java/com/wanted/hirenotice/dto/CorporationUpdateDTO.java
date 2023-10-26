package com.wanted.hirenotice.dto;

import com.wanted.hirenotice.domain.Corporation;
import lombok.Data;

@Data
public class CorporationUpdateDTO {

    private String corporationName;
    private String corporationOverview;
    private String corporationIndustry;
    private Integer foundingYear;

    public Corporation toEntity(){
        return Corporation.builder()
                .corporationName(corporationName)
                .corporationOverview(corporationOverview)
                .corporationIndustry(corporationIndustry)
                .foundingYear(foundingYear)
                .build();
    }
}
