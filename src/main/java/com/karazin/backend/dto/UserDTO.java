package com.karazin.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    private Long id;

    @NotNull(message = "Username mustn't be null")
    @NotEmpty(message = "Username mustn't be empty")
    private String username;

}
