package com.fylx.mapper;

import com.fylx.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getUsers() {

    }

    @Test
    public void InsertUserTest() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUsername("admin");
        user.setPassword("123456");
        int insert = userMapper.insert(user);
        Assert.assertEquals(1, insert);
    }
}