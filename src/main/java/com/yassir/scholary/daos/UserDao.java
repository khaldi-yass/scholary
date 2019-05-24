package com.yassir.scholary.daos;

import com.yassir.scholary.models.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserModel, Long> {

    @Query(value = "ALTER TABLE tablename AUTO_INCREMENT = 1", nativeQuery = true)
    void resetIdGenerator();
}
