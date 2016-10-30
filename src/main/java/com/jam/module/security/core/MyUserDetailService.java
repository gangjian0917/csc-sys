package com.jam.module.security.core;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jam.module.security.entity.Permission;
import com.jam.module.security.service.PermissionService;
import com.jam.module.user.entity.User;
import com.jam.module.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;

	public UserDetails loadUserByUsername(String username) {
		User user = userService.findByUsername(username);
		if (user != null) {
			List<Permission> permissions = permissionService.findByAdminUserId(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (Permission permission : permissions) {
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
				grantedAuthorities.add(grantedAuthority);
			}
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthorities);
		} else {
			log.info("用户" + username + " 不存在");
			throw new UsernameNotFoundException("用户名或密码不正确");
		}
	}

}
