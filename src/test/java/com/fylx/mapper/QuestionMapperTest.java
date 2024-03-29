package com.fylx.mapper;

import com.fylx.entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class QuestionMapperTest {
    @Autowired
    private QuestionMapper mapper;

    @Test
    public void insertTest() {
        String id = UUID.randomUUID().toString().replace("-", "");
        Question question0 = new Question();
        question0.setId(id);
        mapper.insert(question0);
        Question question1 = mapper.selectById(id);
        assertEquals(question0.getId(), question1.getId());

        mapper.deleteById(id);

        assertNull(mapper.selectById(id));
    }
}