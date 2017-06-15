package com.jam.module.suggestion.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jam.common.BaseController;
import com.jam.common.config.SiteConfig;
import com.jam.module.suggestion.entity.Suggestion;
import com.jam.module.suggestion.service.SuggestionService;
import com.jam.util.JsonUtil;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Controller
@RequestMapping("/admin/suggestion")
public class SuggestionAdminController extends BaseController {

	@Autowired
	private SiteConfig siteConfig;
	@Autowired
	private SuggestionService suggestionService;

	/**
	 * 吐槽列表
	 * 
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Integer p, Model model) {
		Page<Suggestion> page = suggestionService.page(p == null ? 1 : p, siteConfig.getPageSize());
		model.addAttribute("page", page);
		return render("/admin/suggestion/list");
	}

	/**
	 * 删除吐槽
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}/delete")
	@ResponseBody
	public String delete(@PathVariable Integer id, HttpServletResponse response) {
		try {
			suggestionService.deleteById(id);
			return redirect(response, "/admin/suggestion/list");
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.error(e.getMessage());
		}
	}

	/**
	 * 吐槽详情
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/{id}/detail")
	public String detail(@PathVariable Integer id, HttpServletResponse response, Model model) {
		if (id != null) {
			Suggestion suggestion = suggestionService.findById(id);
			model.addAttribute("suggestion", suggestion);
			
			suggestion.setReplyCount(suggestion.getReplyCount()+1);
			suggestionService.save(suggestion);
			return render("/admin/suggestion/detail");
		} else {
			renderText(response, "该吐槽不存在");
			return null;
		}
	}
}
