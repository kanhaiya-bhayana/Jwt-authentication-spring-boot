package com.jwtauth.JwtAuth.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String userId;
    private String userName;
    private String userEmail;
}
