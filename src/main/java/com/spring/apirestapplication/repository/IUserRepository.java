package com.spring.apirestapplication.repository;

import com.spring.apirestapplication.model.User;

// Reposotorio de negocio no tiene el @Repository
// Qué es lo que hay que hacer sobre los datos
public interface IUserRepository {
    User findByUsername(String username);

    User saveUser(User user);

    User deleteUserByEmail(String email);
}
