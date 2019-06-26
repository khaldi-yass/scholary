package com.yassir.scholary.frontmodule.soap.controllers;

import com.yassir.scholary.frontmodule.soap.userschema.AllUsersRequest;
import com.yassir.scholary.frontmodule.soap.userschema.AllUsersResponse;
import com.yassir.scholary.frontmodule.soap.userschema.UserRequest;
import com.yassir.scholary.frontmodule.soap.userschema.UserResponse;

import java.util.List;

public interface UserEndpoint {
    UserResponse getUserById(UserRequest request);

    AllUsersResponse getAllUsers(AllUsersRequest request);
}
