package com.karazin.backend.services.impl;

import com.karazin.backend.dto.UserDTO;
import com.karazin.backend.dto.mapper.UserMapper;
import com.karazin.backend.exceptions.EntityIsNullException;
import com.karazin.backend.exceptions.EntityNotFoundException;
import com.karazin.backend.model.User;
import com.karazin.backend.repositories.UserRepository;
import com.karazin.backend.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
// code isn't used
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userDAO, UserMapper userMapper) {
        this.userRepository = userDAO;
        this.userMapper = userMapper;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        if(Objects.isNull(userDTO)) {
            throw new EntityIsNullException("Incoming userDTO is null");
        }
        User userToSave = userMapper.userDTOToUser(userDTO);
        User savedUser = userRepository.save(userToSave);
        log.info("Saved userDTO: {}", savedUser);
        return userMapper.userToUserDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        log.info("All users: {}", users);
        return users.stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
    }

    public Long getIdUserByTelegramId(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        return user.getId();
    }

}

