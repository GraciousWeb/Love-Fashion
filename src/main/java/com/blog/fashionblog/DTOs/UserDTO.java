package com.blog.fashionblog.DTOs;

import com.blog.fashionblog.models.Category;
import com.blog.fashionblog.models.Users;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String userName;
    private String email;
    private String password;
//    public UserDTO(Users user) {
//        this.id = user.getId();
//        this.userName = user.getUserName();
//        this.email = user.getEmail();
//        this.password = user.getPassword();
//
//    }
}
