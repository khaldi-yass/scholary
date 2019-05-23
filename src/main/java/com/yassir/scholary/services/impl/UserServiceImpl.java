package com.yassir.scholary.services.impl;

import com.google.common.collect.Lists;
import com.yassir.scholary.daos.UserDao;
import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.dtos.mappers.Model2DtoMapper;
import com.yassir.scholary.exceptions.IllegalOperationException;
import com.yassir.scholary.exceptions.NotFoundException;
import com.yassir.scholary.models.MediaModel;
import com.yassir.scholary.models.UserModel;
import com.yassir.scholary.services.UserService;
import com.yassir.scholary.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Model2DtoMapper mapper;
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserDto> findAll() {
        return mapper.toUserDtoList(Lists.newArrayList(userDao.findAll()));
    }

    @Override
    public UserDto findById(Long id) {
        return mapper.toUserDto(userDao.findById(id).orElseGet(() -> errorNotFound(id)));
    }

    @Override
    public void create(UserDto userDto) {
        // TODO check if username|email already exists : throw exception
        //return userDao.findById(id).map(emp -> errorAlreadyExists(id)).orElseGet(() -> userDao.save(userModel));
        userDao.save(mapper.toUserModel(userDto));
    }

    @Override
    public void update(UserDto userDto, long id) {
        UserModel userModel = mapper.toUserModel(userDto);
        userDao.findById(id).map(usr -> userDao.save(userModel)).orElseGet(() -> errorNotFound(id));
    }

    @Override
    public void delete(Long id) {
        Optional<UserModel> opt = userDao.findById(id);
        if (!opt.isPresent()) {
            errorNotFound(id);
        }
        userDao.deleteById(id);
    }

    private UserModel errorNotFound(Long id) {
        throw new NotFoundException(getClass(), "User", id.toString());
    }

    private UserModel errorAlreadyExists(Long id) {
        throw new IllegalOperationException(getClass(), MessageFormat.format("User with ID: {0} already exists", id));
    }

    @Override
    public void generateDummyData(int x) {
        List<UserModel> dummyUsers = new ArrayList<>();
        UserModel user;
        for (int i = 1; i <= x; i++) {
            user =
                    new UserModel("UserName_" + i,
                            "passwd",
                            "user_" + i + "@mail.com",
                            "John",
                            "Doe",
                            "Male",
                            LocalDate.of(1995, 1, 1));
            MediaModel picture = new MediaModel();
            picture.setName("Image1");
            picture.setUrl("localhost/pictures/image1.png");
            user.setProfilePicture(picture);
            dummyUsers.add(user);
        }
        userDao.saveAll(dummyUsers);
    }

    @Override
    public void deleteAll() {
        LogUtils.warn(getClass(), "All Users will be cleared from database");
        userDao.deleteAll();
    }
}
