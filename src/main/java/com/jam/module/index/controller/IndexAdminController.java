package com.jam.module.index.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jam.common.BaseController;
import com.jam.module.reply.entity.Reply;
import com.jam.module.reply.service.ReplyService;
import com.jam.module.suggestion.entity.Suggestion;
import com.jam.module.suggestion.service.SuggestionService;
import com.jam.module.topic.entity.Topic;
import com.jam.module.topic.service.TopicService;
import com.jam.module.user.entity.User;
import com.jam.module.user.service.UserService;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Controller
@RequestMapping("/admin")
public class IndexAdminController extends BaseController {
	@Autowired
	private TopicService topicService;
    @Autowired
    private ReplyService replyService;
	@Autowired
	private UserService userService;
	@Autowired
	private SuggestionService suggestionService;

	/**
	 * 首页
	 *
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		Page<Topic> topics = topicService.page(1, Integer.MAX_VALUE, "全部");
        model.addAttribute("topics", topics);
        model.addAttribute("topicsToday", topics);
        Page<Reply> replies = replyService.page(1, Integer.MAX_VALUE);
        model.addAttribute("replies", replies);
        model.addAttribute("repliesToday", replies);
        Page<User> users = userService.pageUser(1, Integer.MAX_VALUE);
        model.addAttribute("users", users);
        model.addAttribute("usersToday", users);
        Page<Suggestion> suggestions = suggestionService.page(1, Integer.MAX_VALUE);
        model.addAttribute("suggestions", suggestions);
        model.addAttribute("suggestionsToday", suggestions);
        
		return render("/admin/index");
	}
	
	private List<Topic> getTodayTopic(Page<Topic> topic) {
		long time = new Date().getTime();
		List<Topic> today = new ArrayList<Topic>();
		if (topic != null) {
			for (Topic t : topic.getContent()) {
				
			}
		}
		return today;

	}
	
	/**
	 * 索引首页
	 * 
	 * @return
	 */
	@RequestMapping("/indexed")
	public String indexed(String s, Model model) {
		model.addAttribute("s", s);
		return render("/admin/indexed/index");
	}

	/**
	 * 索引全部话题
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping("/indexed/indexAll")
	public String indexedAll(HttpServletResponse response) {
		// TODO
		return redirect(response, "/admin/indexed?s=add");
	}

	/**
	 * 删除全部索引
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping("/indexed/deleteAll")
	public String deleteAllIndexed(HttpServletResponse response) {
		// TODO
		return redirect(response, "/admin/indexed?s=del");
	}

}
