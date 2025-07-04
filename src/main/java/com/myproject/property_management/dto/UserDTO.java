package com.myproject.property_management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String ownerName;
    private String ownerEmail;
    private String phone;
    private String password;
}
