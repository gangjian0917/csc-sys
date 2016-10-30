package com.jam.module.suggestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 * 话题列表
	 * 
	 * @param p
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Integer p, Model model) {
		Page<Suggestion> page = suggestionService.page(p == null ? 1 : p, siteConfig.getPageSize(), null);
		model.addAttribute("page", page);
		return render("/admin/suggestion/list");
	}

	/**
	 * 删除话题
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String delete(Integer id) {
		try {
			suggestionService.deleteById(id);
			return JsonUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.error(e.getMessage());
		}
	}

}
