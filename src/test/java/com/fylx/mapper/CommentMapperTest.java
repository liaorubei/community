package com.fylx.mapper;

import com.fylx.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentMapperTest {

    @Autowired
    CommentMapper commentMapper;

    @Test
    public void insertTest() {
        Comment entity = new Comment();
        entity.setContent("test");
        entity.setParentId("1");
        entity.setQuestionId("1");
        entity.setCreateBy("by me");
        int insert = commentMapper.insert(entity);
        // commentMapper.in
        assertEquals(1, insert);
    }
}