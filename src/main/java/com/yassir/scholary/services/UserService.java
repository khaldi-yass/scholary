package com.yassir.scholary.services;

import com.yassir.scholary.models.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> findAllUsers();

    UserModel findUserById(Long id);

    UserModel createUser(UserModel userModel);

    UserModel updateUser(UserModel userModel);

    UserModel deleteUser(Long id);

    void generateDummyData(int x);

    void deleteAll();
}
