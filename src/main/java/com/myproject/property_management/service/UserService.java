package com.myproject.property_management.service;

import com.myproject.property_management.dto.UserDTO;

public interface UserService {

    public UserDTO register(UserDTO userDTO);
    public UserDTO logIn(String email,String password);
}
