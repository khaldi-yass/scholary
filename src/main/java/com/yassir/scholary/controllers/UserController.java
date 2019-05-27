package com.yassir.scholary.controllers;

import com.yassir.scholary.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public interface UserController {

    @GetMapping("/users")
    List<UserDto> findAll();

    @GetMapping("/users/{id}")
    UserDto findById(@PathVariable("id") Long id);

    @PostMapping(value = "/users")
    ResponseEntity create(@RequestBody UserDto userDto);

    @PutMapping(value = "/users/{id}")
    ResponseEntity update(@RequestBody UserDto userDto, @PathVariable("id") Long id);

    @DeleteMapping(value = "/users/{id}")
    ResponseEntity delete(@PathVariable("id") Long id);

    @GetMapping("/consumeUsers")
    String consume();
}
