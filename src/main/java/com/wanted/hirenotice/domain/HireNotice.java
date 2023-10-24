package com.wanted.hirenotice.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "hire_notice")
public class HireNotice {
    @Id
    private Long hireNoticeId;
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

}
