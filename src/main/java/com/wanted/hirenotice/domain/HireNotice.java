package com.wanted.hirenotice.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "hire_notice")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HireNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "corporation_id")
    private Corporation corporation;

}
