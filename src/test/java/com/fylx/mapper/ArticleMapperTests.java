package com.fylx.mapper;

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
        String articleId = "1";
        //ArticleVo vo = articleMapper.selectWithUserById(articleId);
        //System.out.println(vo.getUserAvatar());
        //Assert.assertEquals(articleId, vo.getCreateBy());
    }
}
