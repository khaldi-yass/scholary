package com.yassir.scholary.coremodule.daos;

import com.yassir.scholary.coremodule.models.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, Long> {

}
