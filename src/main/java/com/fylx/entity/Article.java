package com.fylx.entity;

import lombok.Data;

@Data
public class Article {
    private String id;
    private String title;
    private String description;
    private Boolean isOriginal;
    /*
     * 文章类型，当前 空为通用
     * 1为生理安全卫生知识
     * 2为心理安全卫生知识
     * */
    private Integer type;
    private String url;
    private String createBy;
    private String createAt;
    private String modifyAt;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
