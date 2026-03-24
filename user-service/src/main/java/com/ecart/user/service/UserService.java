package com.ecart.user.service;

import com.ecart.user.dto.UserDTO;
import com.ecart.user.dto.UserCreatedEvent;
import com.ecart.user.entity.User;
import com.ecart.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User createUser(UserDTO dto) {
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .build();

        User savedUser = userRepository.save(user);
        publishUserCreatedEvent(savedUser);

        return savedUser;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private void publishUserCreatedEvent(User user) {
        UserCreatedEvent event = UserCreatedEvent.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .address(user.getAddress())
                .createdAt(LocalDateTime.now())
                .build();

    }
}
