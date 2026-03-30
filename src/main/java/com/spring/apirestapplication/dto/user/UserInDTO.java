package com.spring.apirestapplication.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInDTO {
    private String username;
    private String password;
    private String email;
}
