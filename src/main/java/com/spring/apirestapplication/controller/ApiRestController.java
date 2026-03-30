package com.spring.apirestapplication.controller;

import com.spring.apirestapplication.dto.user.UserInDTO;
import com.spring.apirestapplication.dto.user.UserOutDTO;
import com.spring.apirestapplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public ResponseEntity<UserOutDTO> getUserByUsername(@RequestParam String username) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByUsername(username));
    }

    @PostMapping("/post")
    public ResponseEntity<UserOutDTO> postUser(@RequestBody UserInDTO userInDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(userInDTO));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserOutDTO> deleteUser(@RequestParam String email) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(email));
    }
}
