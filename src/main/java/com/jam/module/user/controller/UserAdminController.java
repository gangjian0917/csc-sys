package com.jam.module.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jam.common.BaseController;
import com.jam.common.config.SiteConfig;
import com.jam.module.security.entity.Role;
import com.jam.module.security.service.RoleService;
import com.jam.module.user.entity.User;
import com.jam.module.user.service.UserService;
import com.jam.util.JsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Controller
@RequestMapping("/admin/user")
public class UserAdminController extends BaseController {

	@Autowired
	private SiteConfig siteConfig;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	/**
	 * 用户列表
	 * 
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Integer p, Model model) {
		model.addAttribute("page", userService.pageUser(p == null ? 1 : p, siteConfig.getPageSize()));
		return render("/admin/user/list");
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete")
	public String delete(@PathVariable Integer id, HttpServletResponse response) {
		userService.deleteById(id);
		return redirect(response, "/admin/user/list");
	}

	/**
	 * 配置用户的角色
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}/role")
	public String role(@PathVariable Integer id, Model model) {
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("roles", roleService.findAll());
		return render("/admin/user/role");
	}

	/**
	 * 保存配置用户的角色
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/role", method = RequestMethod.POST)
	public String saveRole(@PathVariable Integer id, Integer[] roleIds, HttpServletResponse response) {
		User user = userService.findById(id);
		Set<Role> roles = new HashSet<>();
		for (int i : roleIds) {
			Role role = roleService.findById(i);
			roles.add(role);
		}
		user.setRoles(roles);
		userService.save(user);
		return redirect(response, "/admin/user/list");
	}

}
