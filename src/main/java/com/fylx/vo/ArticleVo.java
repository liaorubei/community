package com.fylx.vo;

import com.fylx.entity.Article;
import com.fylx.entity.Comment;
import com.fylx.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class ArticleVo extends Article {
    private User creator;
    private List<Comment> comments;
}
