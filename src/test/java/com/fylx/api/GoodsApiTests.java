package com.fylx.api;

import com.fylx.Result;
import com.fylx.entity.Goods;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GoodsApiTests {
    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://127.0.0.1:8888/").addConverterFactory(GsonConverterFactory.create()).build();

    @Value("${filepath}")
    private String root;

    @Test
    public void lll() throws Exception {
        GoodsAPi goodsAPi = retrofit.create(GoodsAPi.class);
        Call<Result<Goods>> call = goodsAPi.getById("1");
        //Result<Goods> o = call.execute().body();
        //call.execute().
        //Assert.assertTrue(o.getCode() == 200);
    }

    @Test
    public void path() {
        File file = new File(root, "4556224.png");
        System.out.println(file.getAbsolutePath());
    }
}
