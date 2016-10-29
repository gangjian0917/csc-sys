package com.jam.module.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jam.common.BaseController;
import com.jam.common.config.SiteConfig;
import com.jam.module.notification.entity.Notification;
import com.jam.module.notification.service.NotificationService;

import java.util.List;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Controller
@RequestMapping("/notification")
public class NotificationController extends BaseController {

    @Autowired
    private SiteConfig siteConfig;
    @Autowired
    private NotificationService notificationService;

    /**
     * 通知列表
     * @param p
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Integer p, Model model) {
        model.addAttribute("page", notificationService.findByTargetUserAndIsRead(p == null ? 1 : p, siteConfig.getPageSize(), getUser(), null));
        //将未读消息置为已读
        notificationService.updateByIsRead(getUser());
        return render("/notification/list");
    }
}
