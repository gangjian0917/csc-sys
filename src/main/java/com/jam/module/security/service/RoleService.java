package com.jam.module.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jam.module.security.dao.RoleDao;
import com.jam.module.security.entity.Permission;
import com.jam.module.security.entity.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 查询所有的角色
     *
     * @return
     */
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    /**
     * 删除角色
     *
     * @param id
     */
    public void deleteById(Integer id) {
        roleDao.delete(id);
    }

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    public Role findById(int id) {
        return roleDao.findOne(id);
    }

    public void save(Role role) {
        roleDao.save(role);
    }

}
