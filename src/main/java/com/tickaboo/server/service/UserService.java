package com.tickaboo.server.service;

import com.tickaboo.server.dto.UserDto;
import com.tickaboo.server.mapper.UserMapper;
import com.tickaboo.server.model.User;
import com.tickaboo.server.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> findById(Long id){
        return userRepository.findById(id).map(userMapper::toDto);
    }

    public UserDto create(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Transactional
    public UserDto update(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: user not found"));
        userMapper.updateFromDto(user, userDto);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

    @Transactional
    public UserDto deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: user not found"));
        userRepository.deleteById(id);
        return userMapper.toDto(user);
    }

}
