package com.tandem6.nopostore.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {
    private String id;
    private String name;
    private String age;
    private String email;
    private String gender;
    private String role;
    private String grade;
    private String password;
}
