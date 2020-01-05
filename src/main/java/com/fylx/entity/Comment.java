package com.fylx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 评论类
 */
@Data
@TableName("Comment")
public class Comment {
    @TableId(type = IdType.AUTO)
    @TableField("Id")
    private Integer id;
    @TableField("Content")
    private String content;

    private String questionId;
    private String parentId;
    private String createBy;
    private Date createAt;
    private Date modifyAt;
    private Integer likeCount;

}
