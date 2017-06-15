package com.jam.module.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.jam.common.BaseEntity;
import com.jam.module.security.entity.Role;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Entity
@Table(name = "cs_user")
@Getter
@Setter
public class User extends BaseEntity {

	@Id
	@GeneratedValue
	private int id;

	// 用户名
	@Column(unique = true, nullable = false)
	private String username;

	// 密码
	@Column(nullable = false)
	private String password;

	// 头像
	@Column(nullable = false)
	private String avatar;

	// 用户邮箱
	private String email;

	// 个人签名
	private String signature;

	// 个人主页
	private String url;

	// 注册时间
	@Column(nullable = false)
	private Date inTime;

	// 用户与角色的关联关系
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "cs_user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles = new HashSet<>();

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", avatar=" + avatar
				+ ", email=" + email + ", signature=" + signature + ", url=" + url + ", inTime=" + inTime + ", roles="
				+ roles + "]";
	}

}
