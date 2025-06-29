package com.myproject.property_management.converter;

import com.myproject.property_management.dto.UserDTO;
import com.myproject.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertDTOtoEntity(UserDTO userDTO){

        UserEntity user = new UserEntity();
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());
        user.setOwnerEmail(userDTO.getOwnerEmail());
        user.setOwnerName(userDTO.getOwnerName());

        return user;
    }

    public UserDTO convertEntitytoDTO(UserEntity userEntity){

        UserDTO userDTO = new UserDTO();
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());
        userDTO.setOwnerName(userEntity.getOwnerName());

        return userDTO;
    }
}
