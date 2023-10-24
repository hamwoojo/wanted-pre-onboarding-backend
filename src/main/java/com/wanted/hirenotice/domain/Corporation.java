package com.wanted.hirenotice.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Corporation {

    @Id
    private Long corporationId;
    private String corporationName;
    private String corporationOverview;
    private String corporationIndustry;
    private Integer foundingYear;



}
