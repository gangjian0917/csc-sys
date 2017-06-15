package com.jam.module.reply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jam.common.BaseController;
import com.jam.common.config.SiteConfig;
import com.jam.module.reply.entity.Reply;
import com.jam.module.reply.service.ReplyService;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Controller
@RequestMapping("/admin/reply")
public class ReplyAdminController extends BaseController {

    @Autowired
    private SiteConfig siteConfig;
    @Autowired
    private ReplyService replyService;

    /**
     * 回复列表
     * @param p
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Integer p, Model model) {
        Page<Reply> page = replyService.page(p == null ? 1 : p, siteConfig.getPageSize());
        model.addAttribute("page", page);
        return render("/admin/reply/list");
    }

}
