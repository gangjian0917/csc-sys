package com.jam.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Setter
@Getter
public class Result<T> {

    private int code;
    private String description;
    private T detail;

}
