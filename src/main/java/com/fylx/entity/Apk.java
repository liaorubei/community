package com.fylx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("Apk")
public class Apk {
    private String id;
    private String createAt;
    private Integer versionCode;
    private String versionName;
    private String path;
    private Integer isRelease;
}
