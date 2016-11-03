package com.jam.module.suggestion.controller;

import java.util.Date;
import java.util.List;

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
import com.jam.module.reply.entity.Reply;
import com.jam.module.reply.service.ReplyService;
import com.jam.module.suggestion.entity.Suggestion;
import com.jam.module.suggestion.service.SuggestionService;
import com.jam.module.topic.entity.Topic;

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

	/**
	 * 创建吐槽
	 *
	 * @return
	 */
	@RequestMapping("/create")
	public String create() {
		return render("/suggestion/create");
	}

	/**
	 * 保存吐槽
	 *
	 * @param title
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(String title, String content, Model model, HttpServletResponse response) {
		String errors = "";
		if (StringUtil.isBlank(title)) {
			errors = "标题不能为空";
		} else {
			Suggestion suggestion = new Suggestion();
			suggestion.setTitle(title);
			suggestion.setContent(content);
			suggestion.setInTime(new Date());
			suggestionService.save(suggestion);
			return redirect(response, "/");
		}
		model.addAttribute("errors", errors);
		return render("/suggestion/create");
	}

	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable int id, HttpServletResponse response, Model model) {
		Suggestion suggestion = suggestionService.findById(id);
		if (suggestion == null) {
			renderText(response, "吐槽不存在");
			return null;
		} else {
			model.addAttribute("suggestion", suggestion);
			return render("/suggestion/edit");
		}
	}

	/**
	 * 更新吐槽
	 *
	 * @param title
	 * @param content
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String update(@PathVariable Integer id, String title, String content, Model model,
			HttpServletResponse response) {
		Suggestion suggestion = suggestionService.findById(id);
		suggestion.setTitle(title);
		suggestion.setContent(content);
		suggestionService.save(suggestion);
		return redirect(response, "/suggestion/" + suggestion.getId());
	}

	/**
	 * 删除吐槽
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
