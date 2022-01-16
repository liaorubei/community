package com.fylx.mapper;

import com.fylx.entity.Goods;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoodsMapperTests {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void CRUDTEST() {
        Goods item = new Goods();
        String id = UUID.randomUUID().toString().replace("-", "");
        item.setId(id);
        item.setTitle("title");
        item.setPrice(22.5);
        item.setThumb(0);
        item.setUrl("http:www.baidu.com");
        goodsMapper.insert(item);

        Goods goods = goodsMapper.selectById(id);
        //Assert.assertEquals(id,goods.getId());
        Assert.assertNotNull(goods);
        //  int i = goodsMapper.deleteById(id);

        goods.setImage("image");
        goodsMapper.updateById(goods);

        Goods goods2 = goodsMapper.selectById(id);
        Assert.assertEquals("image", goods2.getImage());

        int i = goodsMapper.deleteById(id);
        Goods goods3 = goodsMapper.selectById(id);
        Assert.assertNull(goods3);
    }
}
