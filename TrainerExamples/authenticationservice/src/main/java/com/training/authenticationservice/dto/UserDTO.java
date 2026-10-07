package com.training.authenticationservice.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int userid;
    private String username;
    private String password;
    private String role;


}
