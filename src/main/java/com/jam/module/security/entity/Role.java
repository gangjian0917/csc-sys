package com.jam.module.security.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.jam.common.BaseEntity;
import com.jam.module.user.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Entity
@Table(name = "cs_role")
@Getter
@Setter
public class Role extends BaseEntity {

	@Id
	@GeneratedValue
	private int id;

	// 权限标识
	private String name;

	// 权限描述
	private String description;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	// 角色与权限的关联关系
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "cs_role_permission", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
			@JoinColumn(name = "permission_id") })
	private Set<Permission> permissions = new HashSet<>();

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", users=" + users
				+ ", permissions=" + permissions + "]";
	}

}
