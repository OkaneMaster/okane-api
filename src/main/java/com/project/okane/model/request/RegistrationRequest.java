package com.project.okane.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegistrationRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}