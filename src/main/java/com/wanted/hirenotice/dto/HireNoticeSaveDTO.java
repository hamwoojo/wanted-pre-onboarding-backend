package com.wanted.hirenotice.dto;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.wanted.hirenotice.domain.HireNotice;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HireNoticeSaveDTO {
    @NotNull
    private String corporationName;
    @NotNull
    private String nation;
    @NotNull
    private String region;
    @NotNull
    private String hirePosition;
    @NotNull
    private Long hireCompensation;
    @NotNull
    private String techStack;

    public HireNotice toEntity(){
        return HireNotice.builder()
                .corporationName(corporationName)
                .nation(nation)
                .region(region)
                .hirePosition(hirePosition)
                .hireCompensation(hireCompensation)
                .techStack(techStack)
                .build();
    }
}
