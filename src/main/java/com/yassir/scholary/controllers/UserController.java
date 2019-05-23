package com.yassir.scholary.controllers;

import com.yassir.scholary.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface UserController {

    @GetMapping("/")
    String rootPath();

    @GetMapping("/users")
    List<UserDto> findAllUsers();

    @GetMapping("/users/{id}")
    UserDto findUserById(@PathVariable("id") Long id);

    @PostMapping(value = "/users")
    UserDto createUser(@RequestBody UserDto userDto);

    @PutMapping(value = "/users/{id}")
    UserDto updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id);

    @DeleteMapping(value = "/users/{id}")
    ResponseEntity deleteUser(@PathVariable("id") Long id);

    @GetMapping("/consumeUsers")
    String consume();
}
