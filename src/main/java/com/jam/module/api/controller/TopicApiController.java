package com.jam.module.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jam.common.BaseController;
import com.jam.module.topic.service.TopicService;
import com.jam.module.user.entity.User;
import com.jam.util.JsonUtil;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * http://tomoya.cn
 */
@Controller
@RequestMapping("/api/topic")
public class TopicApiController extends BaseController {

    @Autowired
    private TopicService topicService;

    /**
     * 对话题点赞
     *
     * @param topicId
     * @return
     */
    @RequestMapping(value = "/up", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String up(Integer topicId) {
        if (topicId != null) {
            User user = getUser();
            topicService.addOneUp(user.getId(), topicId);
            return JsonUtil.success();
        }
        return JsonUtil.error("点赞失败");
    }

    /**
     * 对话题取消点赞
     *
     * @param topicId
     * @return
     */
    @RequestMapping(value = "/unup", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String unup(Integer topicId) {
        if (topicId != null) {
            User user = getUser();
            topicService.reduceOneUp(user.getId(), topicId);
            return JsonUtil.success();
        }
        return JsonUtil.error("取消点赞失败");
    }

}
