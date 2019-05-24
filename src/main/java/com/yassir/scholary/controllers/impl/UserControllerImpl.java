package com.yassir.scholary.controllers.impl;

import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.services.UserService;
import com.yassir.scholary.utils.LogUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements com.yassir.scholary.controllers.UserController {

    private UserService userService;
    private RestTemplate restTemplate;

    public UserControllerImpl(UserService userService) {
        restTemplate = new RestTemplate();
        this.userService = userService;
    }

    @Override
    @GetMapping("/")
    public String rootPath() {
        return "<h1>Hello World</h1>";
    }

    @Override
    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @Override
    @PostMapping(value = "/users")
    public ResponseEntity create(@RequestBody UserDto userDto) {
        userService.create(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created.");
    }

    @Override
    @PutMapping(value = "/users/{id}")
    public ResponseEntity update(@RequestBody UserDto userDto, @PathVariable("id") Long id) {
        userService.update(userDto, id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully updated.");
    }

    @Override
    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted.");
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
