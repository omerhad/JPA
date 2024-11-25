package com.CPmovement.mapping_and_viewing_info.service;

import com.CPmovement.mapping_and_viewing_info.exception.ApiRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.CPmovement.mapping_and_viewing_info.entity.User;
import com.CPmovement.mapping_and_viewing_info.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(cacheNames = "users", key = "#username + ':' + #password")
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            logger.info("User logged in successfully");
            return user;
        }
        logger.error("Username or password incorrect");
        throw new ApiRequestException("Invalid username or password");
    }

    public User signIn(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            logger.error("Username already exists");
            throw new ApiRequestException("Username already exists");
        }
        logger.info("User signed in successfully");
        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateStatus(Long userId, String status) {
        if (userId == null || userId <= 0) {
            logger.error("Invalid user id must be greater than 0");
            throw new ApiRequestException("Invalid user id");
        }
        if (status == null) {
            logger.error("Invalid status");
            throw new ApiRequestException("Invalid status");
        }
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            logger.error("User not found");
            throw new ApiRequestException("User not found");
        }
        user.setStatus(status);
        logger.info("User {} status updated to {}", user, status);
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#userId")
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}