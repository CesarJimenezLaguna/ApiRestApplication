package com.spring.apirestapplication.service;

import com.spring.apirestapplication.dto.user.UserInDTO;
import com.spring.apirestapplication.dto.user.UserOutDTO;
import com.spring.apirestapplication.mapper.UserMapper;
import com.spring.apirestapplication.model.User;
import com.spring.apirestapplication.repository.IUserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserOutDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userMapper.toDTO(user);
    }

    @Override
    public UserOutDTO saveUser(UserInDTO userInDTO) {
        User user = userMapper.toEntity(userInDTO);
        User savedUser = userRepository.saveUser(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    @Transactional // Nivel Atómico
    public UserOutDTO deleteUser(String email) {
        User retrievedUser = userRepository.deleteUserByEmail(email);
        return userMapper.toDTO(retrievedUser);
    }
}
