package com.wanted.hirenotice.dto;

import com.sun.istack.NotNull;
import com.wanted.hirenotice.domain.Corporation;
import lombok.Data;


@Data
public class CorporationSaveDTO {
    @NotNull
    private String corporationName;
    @NotNull
    private String corporationOverview;
    @NotNull
    private String corporationIndustry;
    @NotNull
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
