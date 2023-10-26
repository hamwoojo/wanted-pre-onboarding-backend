package com.wanted.hirenotice.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Corporation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corporation_id")
    private Long corporationId;
    @NotNull
    private String corporationName;
    @NotNull
    private String corporationOverview;
    @NotNull
    private String corporationIndustry;
    @NotNull
    private Integer foundingYear;


}
