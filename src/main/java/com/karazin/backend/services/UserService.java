package com.karazin.backend.services;

import com.karazin.backend.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    Long getIdUserByTelegramId(Long telegramId);

}
