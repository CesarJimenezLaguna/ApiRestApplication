package com.spring.apirestapplication.service;

import com.spring.apirestapplication.dto.user.UserInDTO;
import com.spring.apirestapplication.dto.user.UserOutDTO;

public interface IUserService {
    UserOutDTO getUserByUsername(String username);

    UserOutDTO saveUser(UserInDTO userInDTO);

    UserOutDTO deleteUser(UserInDTO userInDTO);
}
