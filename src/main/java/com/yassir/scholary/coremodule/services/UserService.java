package com.yassir.scholary.coremodule.services;

import com.yassir.scholary.coremodule.dtos.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Long id);

    void create(UserDto userDto);

    void update(UserDto userDto, long id);

    void delete(Long id);

    void generateDummyData(int x);

    void deleteAll();

    List<Long> getAvailableUserIds();
}
