package com.code.mssecurity.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String name;
    private String lastname;
    private String email;
    private String password;
}
