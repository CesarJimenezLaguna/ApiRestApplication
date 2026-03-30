package com.spring.apirestapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.apirestapplication.model.User;

import java.util.Optional;

// El que realiza las operaciones en la base de datos
@Repository
public interface IUserJPARepository extends JpaRepository<User, Long> { // JPA Repository facilita las operaciones
                                                                        // simples en la
    // base de datos <Tipo de objero que devuelve en las llamadas predeterminadas,
    // Long == tipo de dato de la clave primaria>

    Optional<User> findByUsername(String username);

    Optional<User> deleteUserByEmail(String email);
}
