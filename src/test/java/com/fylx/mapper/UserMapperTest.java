package com.fylx.mapper;

import com.fylx.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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
        String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        user.setUsername("admin");
        user.setPassword("123456");
        int insert = userMapper.insert(user);
        Assert.assertEquals(1, insert);

        //删除
        int i = userMapper.deleteById(id);

        //验证
        User user1 = userMapper.selectById(id);
        Assert.assertNull(user1);
    }

    @Test
    public void getByGroupId() {
        List<User> users = userMapper.getByGroupId("1");
        users.forEach(i -> System.out.println("username="+i.getUsername()));
        //Assert.assertTrue(users.size() > 0);
    }
}