package com.wanted.hirenotice.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long userId;
    @NotNull
    private String accountId;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private String jobCategory;
    private String job;
    private String career;
    private Integer yearOfExperience;
    @NotNull
    private String education;
    private String educationMajor;
}
