package com.fylx.mapper;

import com.fylx.entity.Apk;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiMapperTests {
    @Autowired
    ApkMapper apkMapper;

    @Test
    public void selectWithUserTests() {
        Apk apk = apkMapper.selectLatest();
        //Assert.assertEquals((Integer) 5, apk.getVersionCode());
    }
}
