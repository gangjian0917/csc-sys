package com.jam.module.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.security.entity.Permission;

import java.util.List;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface PermissionDao extends JpaRepository<Permission, Integer> {

	List<Permission> findByPidGreaterThan(int pid);

	List<Permission> findByPid(int pid);

	void deleteByPid(int pid);
}
