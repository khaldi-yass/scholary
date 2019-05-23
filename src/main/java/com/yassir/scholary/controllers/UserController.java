package com.yassir.scholary.controllers;

import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.dtos.mappers.Model2DtoMapper;
import com.yassir.scholary.models.UserModel;
import com.yassir.scholary.services.UserService;
import com.yassir.scholary.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    private RestTemplate restTemplate;

    @Autowired
    Model2DtoMapper mapper;

    public UserController(UserService userService) {
        restTemplate = new RestTemplate();
        this.userService = userService;
    }

    @GetMapping("/")
    public String rootPath() {
        return "Hello World";
    }

    @GetMapping("/users")
    public List<UserModel> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserDto findUserById(@PathVariable("id") Long id) {
        return mapper.toUserDto(userService.findUserById(id));
    }

    @PostMapping(value = "/users")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }

    @PutMapping(value = "/users/{id}")
    public UserModel updateUser(@RequestBody UserModel userModel, @PathVariable("id") Long id) {
        return userService.updateUser(userModel);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfuly deleted.");
    }

    @GetMapping("/consumeUsers")
    public String consume() {
        LogUtils.debug(getClass(), "Users Consumer");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        List response = restTemplate.exchange("https://localhost/users", HttpMethod.GET, entity, List.class).getBody();
        return "Response returned " + response.size() + " Element";
    }
}
