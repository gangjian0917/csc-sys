package com.jam.module.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.user.entity.User;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
