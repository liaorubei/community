package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fylx.Result;
import com.fylx.entity.Goods;
import com.fylx.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Value("${filepath}")
    private String filepath;

    private GoodsMapper goodsMapper;

    @ResponseBody
    @GetMapping("/")
    public Result<List<Goods>> list(){
        Result<List<Goods>> result=new Result<List<Goods>>();
        try {
            result.setData(goodsMapper.selectList(null));
        }catch (Exception ex){}
        return result;
    }

    @ResponseBody
    @GetMapping(value = "goods")
    public Result<Goods> getGoods() {
        Result<Goods> result = new Result<>();
        result.setData(new Goods());

        try {
            File folder = new File(filepath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File file = new File(filepath, "test.bmp");

            FileOutputStream outputStream = new FileOutputStream(file);
            outputStream.write(65);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }
}
