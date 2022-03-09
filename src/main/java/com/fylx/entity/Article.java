package com.fylx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Article")
public class Article {
    private String id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 内容正文
     */
    private String content;

    /**
     * 文章描述,说明
     */
    private String description;

    /**
     * 文章是否原创
     */
    private Boolean isOriginal;

    /**
     * 文章类型，当前 空为通用
     * 1为生理安全卫生知识
     * 2为心理安全卫生知识
     * 3为兼容处理问题,暂定义3为问题
     */
    private Integer type;

    /**
     * 文章的地址,当文章不是原创是,一般应该提供地址
     */
    private String url;

    /**
     * 文章属于那个群组
     */
    private String groupId;
    private String createBy;
    private String createAt;
    private String modifyAt;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
