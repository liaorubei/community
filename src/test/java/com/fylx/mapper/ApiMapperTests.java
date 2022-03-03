package com.fylx.mapper;

import com.fylx.entity.Apk;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiMapperTests {
    @Autowired
    ApkMapper apkMapper;

    @Test
    public void selectWithUserTests() {
        Apk apk = new Apk();
        String id = UUID.randomUUID().toString().replace("-", "");
        apk.setId(id);
        apk.setVersionCode(999);
        apk.setPath("---");
        apk.setIsRelease(1);
        apk.setVersionName("name");
        apk.setCreateAt("2020-02-02 12:12:12");
        apkMapper.insert(apk);
        Apk apk1 = apkMapper.selectLatest();
        Assert.assertEquals((Integer) 999, apk.getVersionCode());

        apkMapper.deleteById(id);

        Apk apk2 = apkMapper.selectById(id);
        Assert.assertNull(apk2);

    }
}
