package com.karazin.backend.dto;

import com.karazin.backend.model.User;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ResultDTO {

    @NotNull(message = "Text mustn't be null")
    @NotEmpty(message = "Text mustn't be empty")
    private String text;

    private User user;

    private String createdOn;

}
