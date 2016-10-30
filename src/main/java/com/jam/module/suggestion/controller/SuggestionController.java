package com.jam.module.suggestion.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jam.common.BaseController;
import com.jam.javautils.string.StringUtil;
import com.jam.module.collect.service.CollectService;
import com.jam.module.reply.service.ReplyService;
import com.jam.module.suggestion.entity.Suggestion;
import com.jam.module.suggestion.service.SuggestionService;
import com.jam.module.user.entity.User;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Controller
@RequestMapping("/suggestion")
public class SuggestionController extends BaseController {

	@Autowired
	private SuggestionService suggestionService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private CollectService collectService;

	/**
	 * 创建话题
	 *
	 * @return
	 */
	@RequestMapping("/create")
	public String create() {
		return render("/suggestion/create");
	}

	/**
	 * 保存话题
	 *
	 * @param title
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(String tab, String title, String content, Model model, HttpServletResponse response) {
		String errors = "";
		if (StringUtil.isBlank(title)) {
			errors = "标题不能为空";
		} else if (StringUtil.isBlank(tab)) {
			errors = "版块不能为空";
		} else {
			User user = getUser();
			Suggestion suggestion = new Suggestion();
			suggestion.setTab(tab);
			suggestion.setTitle(title);
			suggestion.setContent(content);
			suggestion.setInTime(new Date());
			suggestion.setUp(0);
			suggestion.setView(0);
			suggestion.setUser(user);
			suggestion.setGood(false);
			suggestion.setTop(false);
			suggestionService.save(suggestion);
			return redirect(response, "/suggestion/" + suggestion.getId());
		}
		model.addAttribute("errors", errors);
		return render("/suggestion/create");
	}

	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable int id, HttpServletResponse response, Model model) {
		Suggestion suggestion = suggestionService.findById(id);
		if (suggestion == null) {
			renderText(response, "话题不存在");
			return null;
		} else {
			model.addAttribute("suggestion", suggestion);
			return render("/suggestion/edit");
		}
	}

	/**
	 * 更新话题
	 *
	 * @param title
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String update(@PathVariable Integer id, String tab, String title, String content, Model model,
			HttpServletResponse response) {
		Suggestion suggestion = suggestionService.findById(id);
		User user = getUser();
		if (suggestion.getUser().getId() == user.getId()) {
			suggestion.setTab(tab);
			suggestion.setTitle(title);
			suggestion.setContent(content);
			suggestionService.save(suggestion);
			return redirect(response, "/suggestion/" + suggestion.getId());
		} else {
			renderText(response, "非法操作");
			return null;
		}
	}

	/**
	 * 话题详情
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	/*
	 * @RequestMapping("/{id}") public String detail(@PathVariable Integer id,
	 * HttpServletResponse response, Model model) { if (id != null) { Suggestion
	 * suggestion = suggestionService.findById(id); List<Reply> replies =
	 * replyService.findByTopicId(id); model.addAttribute("suggestion",
	 * suggestion); model.addAttribute("replies", replies);
	 * model.addAttribute("user", getUser()); model.addAttribute("author",
	 * suggestion.getUser()); model.addAttribute("otherSuggestions",
	 * suggestionService.findByUser(1, 7, suggestion.getUser()));
	 * model.addAttribute("collect",
	 * collectService.findByUserAndTopic(getUser(), suggestion));
	 * model.addAttribute("collectCount",
	 * collectService.countByTopic(suggestion)); return
	 * render("/suggestion/detail"); } else { renderText(response, "话题不存在");
	 * return null; } }
	 */
	/**
	 * 删除话题
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable Integer id, HttpServletResponse response) {
		if (id != null) {
			suggestionService.deleteById(id);
		}
		return redirect(response, "/");
	}
}
