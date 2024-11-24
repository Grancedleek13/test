package com.example.service2;

import com.example.service2.DatabaseEntities.User;
import com.example.service2.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isUserExists(String username) {
        return userRepository.findByName(username).isPresent();
    }

    public void registerNewUser(String username) {
        User user = new User();
        user.setName(username);
        userRepository.save(user);
    }
}