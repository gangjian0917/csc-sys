package com.jam.template;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Component
public class CustomTags extends SimpleHash {

    public CustomTags(){
        put("testList",new TestDirective());
    }
}