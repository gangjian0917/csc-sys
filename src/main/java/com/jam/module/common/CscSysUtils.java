package com.jam.module.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jam.common.config.SiteConfig;
import com.jam.javautils.string.StringUtil;
import com.jam.module.reply.entity.Reply;
import com.jam.module.security.entity.Role;
import com.jam.module.topic.entity.Topic;
import com.jam.module.user.entity.User;
import com.jam.module.user.service.UserService;

public class CscSysUtils {
	/**
	 * "管理通告-非公开回复" 只能查看 管理员和自己的回复
	 * 
	 * @param topic
	 * @param replies
	 * @return
	 */
	public static List<Reply> getPrivateReplies(UserService userService, User loginUser, SiteConfig siteConfig,
			Topic topic, List<Reply> replies) {
		List<Reply> result = new ArrayList<Reply>();

		if (siteConfig.getReplyPrivateSection().equals(topic.getTab())) {
			if (loginUser == null) {
				// 未登录用户禁止查看"管理通告-非公开回复"下面的回复
				Reply reply = new Reply();
				reply.setId(Integer.MAX_VALUE);
				reply.setInTime(new Date());
				reply.setTopic(topic);
				reply.setUp(0);
				reply.setUpIds("0");
				reply.setUser(userService.findById(1));
				reply.setContent("游客不能查看该板块中的回复");
				result.add(reply);
				return result;
			}

			for (Reply re : replies) {
				// 可以看到这条回复的人包括：话题的主人、回复的作者、管理员、管理员的回复
				if (isAdminRole(siteConfig, loginUser)) {
					result.add(re);
				} else if (loginUser.getId() == topic.getUser().getId() || loginUser.getId() == re.getUser().getId()
						|| isAdminReply(siteConfig, re)) {
					if (isContainAt(re.getContent())) {
						if (isAtMe(re.getContent(), loginUser.getUsername())) {
							result.add(re);
						}
					} else {
						result.add(re);
					}
				}
			}
		}

		return result;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static boolean isAdminRole(SiteConfig siteConfig, User user) {
		if (user != null) {
			for (Role r : user.getRoles()) {
				if (r.getId() == siteConfig.getAdminRoleId()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param reply
	 * @return
	 */
	public static boolean isAdminReply(SiteConfig siteConfig, Reply reply) {
		User user = reply.getUser();
		return isAdminRole(siteConfig, user);
	}

	public static boolean isContainAt(String content) {
		List<String> users = StringUtil.fetchUsers(content);
		if (users != null && users.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 回复中，如果有@用户。则只有被@的用户 和 管理员，才能看到该回复
	 *
	 * @param content
	 * @return
	 */
	public static boolean isAtMe(String content, String loginUser) {
		boolean result = false;
		if (StringUtil.isBlank(content) || StringUtil.isBlank(loginUser))
			return result;
		// 处理@
		List<String> users = StringUtil.fetchUsers(content);
		if (users == null || users.size() == 0) {
			result = false;
		} else {
			for (String user : users) {
				if (loginUser.equals(user)) {
					result = true;
				}
			}
		}

		return result;
	}
}
