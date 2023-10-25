package com.wanted.hirenotice.dto;

import com.wanted.hirenotice.domain.HireNotice;
import lombok.Data;

@Data
public class HireNoticeUpdateDTO {
    private String corporationName;
    private String nation;
    private String region;
    private String hirePosition;
    private Long hireCompensation;
    private String techStack;

    public HireNotice toEntity(HireNoticeUpdateDTO hireNoticeSaveDTO){
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
