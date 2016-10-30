package com.jam.module.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.security.entity.Role;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Integer> {
}
