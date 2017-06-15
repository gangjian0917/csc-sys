package com.jam.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
public class JsonUtil {

    public static String success() {
        return success(null);
    }

    public static String success(Object detail) {
        Result result = new Result();
        result.setCode(200);
        result.setDescription("success");
        result.setDetail(detail);
        return JSON.toJSONString(result);
    }

    public static String error() {
        return error(null);
    }

    public static String error(String description) {
        Result result = new Result();
        result.setCode(201);
        result.setDescription(description);
        result.setDetail(null);
        return JSON.toJSONString(result);
    }
}
