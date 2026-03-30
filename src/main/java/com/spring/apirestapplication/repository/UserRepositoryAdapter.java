package com.spring.apirestapplication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.apirestapplication.model.User;

// Conecta el qué hay que hacer con el cómo se hace (para no deperder y poder cambiar en un futuro)
@Component
public class UserRepositoryAdapter implements IUserRepository {
    @Autowired
    private IUserJPARepository userJPARepository;

    @Override
    public User findByUsername(String username) {
        return userJPARepository.findByUsername(username).orElseThrow(() -> new RuntimeException(
                "UserRepositoryAdapter - findByUsername - User with username: " + username + " not found"));
    }

    @Override
    public User saveUser(User user) {
        return userJPARepository.save(user);
    }

    @Override
    public User deleteUserByEmail(String email) {
        return userJPARepository.deleteUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("UserRepositoryAdapter - deleteUserByEmail - User with email: "
                        + email + " not found to deleted it :)"));
    }
}
