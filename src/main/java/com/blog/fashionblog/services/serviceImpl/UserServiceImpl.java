package com.blog.fashionblog.services.serviceImpl;

import com.blog.fashionblog.DTOs.UserDTO;
import com.blog.fashionblog.models.Users;
import com.blog.fashionblog.repositories.UserRepository;
import com.blog.fashionblog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.mindrot.jbcrypt.*;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        Users users = map2Entity(userDTO);
        String hashedPassword = BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt());
        users.setPassword(hashedPassword);
        Users savedUsers = userRepository.save(users);
        return map2UserDTO(savedUsers);

    }


    @Override
    public UserDTO loginUser(UserDTO userDTO) {
        Users users = userRepository.findByUserName(userDTO.getUserName()).orElseThrow(
                () -> new RuntimeException("Username not found"));
        if (BCrypt.checkpw(userDTO.getPassword(),users.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return map2UserDTO(users);

            }


    public Users map2Entity(UserDTO userDTO) {
        Users users = new Users();
        users.setUserName(userDTO.getUserName());
        users.setEmail(userDTO.getEmail());
        return users;

    }

    public UserDTO map2UserDTO(Users users) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(users.getUserName());
        userDTO.setEmail(users.getEmail());
        userDTO.setPassword(users.getPassword());
        return userDTO;


    }
}
