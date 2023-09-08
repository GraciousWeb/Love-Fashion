package com.blog.fashionblog.controllers;

import com.blog.fashionblog.DTOs.UserDTO;
import com.blog.fashionblog.repositories.UserRepository;
import com.blog.fashionblog.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class AuthController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserDTO> saveUser (@RequestBody UserDTO userDTO){
       UserDTO savedUser = userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser (@RequestBody UserDTO userDTO, HttpServletRequest servletRequest){
        UserDTO userDTO1 = userService.loginUser(userDTO);
        if (userDTO1 != null){
            HttpSession session = servletRequest.getSession();
            session.setAttribute("userId", userDTO1.getId());
        }
        return new ResponseEntity<>("Welcome" + userDTO1.getUserName(), HttpStatus.OK);
    }




}
