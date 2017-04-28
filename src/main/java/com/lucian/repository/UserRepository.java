package com.lucian.repository;

import com.lucian.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 2017/4/23.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public UserEntity findByUsername(String username);

    public UserEntity findByPassword(String password);

}
