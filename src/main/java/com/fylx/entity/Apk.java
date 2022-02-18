package com.fylx.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Apk {
    private String id;
    private String createAt;
    private Integer versionCode;
    private String versionName;
    private String path;
    private Integer isRelease;
}
