package com.fylx.mapper;

import com.fylx.entity.Article;
import com.fylx.vo.ArticleVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleMapperTests {
    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void selectWithUserTests() {
        String articleId = "1999999999";
        Article item = new Article();
        item.setId(articleId);
        item.setTitle("title");
        item.setDescription("desc");
        item.setContent("content");
        articleMapper.insert(item);

        Article article = articleMapper.selectById(articleId);
        Assert.assertEquals(item.getContent(), article.getContent());

        articleMapper.deleteById(articleId);

        Assert.assertNull(articleMapper.selectById(articleId));
    }
}
