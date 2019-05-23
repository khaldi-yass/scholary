package com.yassir.scholary.services;

import com.google.common.collect.Lists;
import com.yassir.scholary.daos.UserDao;
import com.yassir.scholary.exceptions.IllegalOperationException;
import com.yassir.scholary.exceptions.NotFoundException;
import com.yassir.scholary.models.MediaModel;
import com.yassir.scholary.models.UserModel;
import com.yassir.scholary.utils.LogUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserModel> findAllUsers() {
        return Lists.newArrayList(userDao.findAll());
    }

    @Override
    public UserModel findUserById(Long id) {
        return userDao.findById(id).orElseGet(() -> errorNotFound(id));
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        long id = userModel.getId();
        return userDao.findById(id).map(emp -> errorAlreadyExists(id)).orElseGet(() -> userDao.save(userModel));
    }

    @Override
    public UserModel updateUser(UserModel userModel) {
        long id = userModel.getId();
        return userDao.findById(id).map(emp -> userDao.save(userModel)).orElseGet(() -> errorNotFound(id));
    }

    @Override
    public UserModel deleteUser(Long id) {
        return userDao.findById(id).map(emp -> {
            userDao.deleteById(id);
            return new UserModel();
        }).orElseGet(() -> errorNotFound(id));
    }

    private UserModel errorNotFound(Long id) {
        throw new NotFoundException(getClass(), getClass().getSimpleName(), id.toString());
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
