package com.yassir.scholary.frontmodule.soap.controllers.impl;

import com.yassir.scholary.coremodule.dtos.UserDto;
import com.yassir.scholary.coremodule.services.UserService;
import com.yassir.scholary.frontmodule.soap.config.SoapWSConfig;
import com.yassir.scholary.frontmodule.soap.controllers.UserEndpoint;
import com.yassir.scholary.frontmodule.soap.mappers.Dto2SchemaMapper;
import com.yassir.scholary.frontmodule.soap.userschema.AllUsersRequest;
import com.yassir.scholary.frontmodule.soap.userschema.AllUsersResponse;
import com.yassir.scholary.frontmodule.soap.userschema.UserRequest;
import com.yassir.scholary.frontmodule.soap.userschema.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class UserEndpointImpl implements UserEndpoint {

    private UserService userService;
    private Dto2SchemaMapper mapper;

    @Autowired
    public UserEndpointImpl(UserService userService, Dto2SchemaMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @Override
    @PayloadRoot(namespace = SoapWSConfig.USER_TNS, localPart = "UserRequest")
    @ResponsePayload
    public UserResponse getUserById(@RequestPayload UserRequest request) {
        UserDto userDto = userService.findById(request.getId());
        UserResponse response = new UserResponse();
        response.setUser(mapper.toUserType(userDto));
        return response;
    }

    @Override
    @PayloadRoot(namespace = SoapWSConfig.USER_TNS, localPart = "AllUsersRequest")
    @ResponsePayload
    public AllUsersResponse getAllUsers(@RequestPayload AllUsersRequest request) {
        List<UserDto> userDto = userService.findAll();
        AllUsersResponse response = new AllUsersResponse();
        response.getUser().addAll(mapper.toUserTypeList(userDto));
        return response;
    }
}
