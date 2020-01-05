package com.fylx;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String desc;
    private T data;
}
