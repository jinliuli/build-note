package com.test.buildnote.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsersDTO {

    private Long id;
    private String userName;
    private String loginId;
    private String password;
    private String phoneNumber;
    private String role;
    private String companyName;
    private String department;
    private String jobType;
    private String isActive;

}
