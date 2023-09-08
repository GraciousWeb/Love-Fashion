package com.blog.fashionblog.services;

import com.blog.fashionblog.DTOs.UserDTO;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO loginUser(UserDTO userDTO);
}
