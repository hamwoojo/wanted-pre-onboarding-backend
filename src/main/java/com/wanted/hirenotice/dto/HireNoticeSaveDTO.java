package com.wanted.hirenotice.dto;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.wanted.hirenotice.domain.HireNotice;
import lombok.Data;

@Data
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

    public HireNotice toEntity(HireNoticeSaveDTO hireNoticeSaveDTO){
        return HireNotice.builder()
                .corporationName(hireNoticeSaveDTO.corporationName)
                .nation(hireNoticeSaveDTO.nation)
                .region(hireNoticeSaveDTO.region)
                .hirePosition(hireNoticeSaveDTO.hirePosition)
                .hireCompensation(hireNoticeSaveDTO.hireCompensation)
                .techStack(hireNoticeSaveDTO.techStack)
                .build();
    }
}
