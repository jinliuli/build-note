package com.test.buildnote.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@ToString
@Builder
//@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_generator")
    @SequenceGenerator(name="users_seq_generator", sequenceName = "seqUsers", allocationSize = 1)
    private Long id;

    @Column(unique =  true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String workType;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String jopType;

    @Column(nullable = false)
    private String isActive;


}
