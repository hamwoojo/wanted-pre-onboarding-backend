package com.wanted.hirenotice.domain;

import javax.persistence.*;

@Entity
public class Corporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporation_id")
    private Long corporationId;
    private String corporationName;
    private String corporationOverview;
    private String corporationIndustry;
    private Integer foundingYear;



}
