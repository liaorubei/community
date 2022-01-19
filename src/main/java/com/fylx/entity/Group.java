package com.fylx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Groups")//防止关键字冲突，特加s后缀
public class Group {
    private String id;
    private String title;
    private String description;
    private String leader;
    private String createBy;
    private String createAt;
    private String avatar;
}
