package com.yassir.scholary.daos;

import com.yassir.scholary.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, Long> {

}
