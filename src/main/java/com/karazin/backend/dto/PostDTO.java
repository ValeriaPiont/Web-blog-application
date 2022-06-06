package com.karazin.backend.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PostDTO {

    private Long id;

    @NotNull(message = "Text mustn't be null")
    @NotEmpty(message = "Text mustn't be empty")
    @Size(max = 140)
    private String text;

    @NotNull(message = "Text mustn't be null")
    @NotEmpty(message = "Text mustn't be empty")
    private String username;

}
