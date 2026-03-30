package com.spring.apirestapplication.mapper;

import org.springframework.stereotype.Component;

import com.spring.apirestapplication.dto.user.UserInDTO;
import com.spring.apirestapplication.dto.user.UserOutDTO;
import com.spring.apirestapplication.model.User;

@Component
public class UserMapper {
    public User toEntity(UserInDTO userInDTO) {
        return User.builder()
                .username(userInDTO.getUsername())
                .password(userInDTO.getPassword())
                .email(userInDTO.getEmail())
                .build();
    }

    public UserOutDTO toDTO(User user) {
        UserOutDTO userOutDTO = new UserOutDTO(user.getUsername(), user.getEmail());
        return userOutDTO;
    }
}
