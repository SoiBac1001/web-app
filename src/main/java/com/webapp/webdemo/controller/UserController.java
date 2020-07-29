package com.webapp.webdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/authorization/users")
public class UserController {
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("test");
    }
}
