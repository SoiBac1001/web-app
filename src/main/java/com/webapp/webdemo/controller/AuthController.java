package com.webapp.webdemo.controller;

import com.webapp.webdemo.payload.request.LoginRequest;
import com.webapp.webdemo.payload.request.SignUpRequest;
import com.webapp.webdemo.payload.response.ApiResponse;
import com.webapp.webdemo.payload.response.TokenResponse;
import com.webapp.webdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest){
        return new ResponseEntity<>(userService.registerUser(signUpRequest), HttpStatus.CREATED);
    }
}
