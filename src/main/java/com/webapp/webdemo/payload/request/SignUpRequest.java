package com.webapp.webdemo.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
}
