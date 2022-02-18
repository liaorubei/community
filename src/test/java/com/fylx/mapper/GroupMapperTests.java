package com.fylx.mapper;

import com.fylx.entity.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GroupMapperTests {
    @Autowired
    private GroupsMapper groupsMapper;

    @Test
    public void getByUserId() {
        List<Group> groups = groupsMapper.getByUserId("1");
        //Assert.assertTrue(groups.size() > 0);
    }
}
