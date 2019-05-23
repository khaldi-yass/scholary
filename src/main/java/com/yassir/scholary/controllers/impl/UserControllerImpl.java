package com.yassir.scholary.controllers.impl;

import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.dtos.mappers.Model2DtoMapper;
import com.yassir.scholary.services.UserService;
import com.yassir.scholary.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class UserControllerImpl implements com.yassir.scholary.controllers.UserController {

    private UserService userService;
    private RestTemplate restTemplate;

    @Autowired
    Model2DtoMapper mapper;

    public UserControllerImpl(UserService userService) {
        restTemplate = new RestTemplate();
        this.userService = userService;
    }

    @Override
    public String rootPath() {
        return "<h1>Hello World</h1>";
    }

    @Override
    @GetMapping("/users")
    public List<UserDto> findAllUsers() {
        return mapper.toUserDtoList(userService.findAllUsers());
    }

    @Override
    @GetMapping("/users/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return mapper.toUserDto(userService.findUserById(id));
    }

    @Override
    @PostMapping(value = "/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return mapper.toUserDto(userService.createUser(mapper.toUserModel(userDto)));
    }

    @Override
    @PutMapping(value = "/users/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long id) {
        return mapper.toUserDto(userService.updateUser(mapper.toUserModel(userDto), id));
    }

    @Override
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfuly deleted.");
    }

    @Override
    @GetMapping("/consumeUsers")
    public String consume() {
        LogUtils.debug(getClass(), "Users Consumer");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        List response = restTemplate.exchange("https://localhost/users", HttpMethod.GET, entity, List.class).getBody();
        return "Response returned " + response.size() + " Element";
    }
}
