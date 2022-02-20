package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fylx.Result;
import com.fylx.entity.Goods;
import com.fylx.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Value("${filepath}")
    private String filepath;

    @Autowired
    private GoodsMapper goodsMapper;

    @ResponseBody
    @GetMapping()
    public Result<List<Goods>> list() {
        Result<List<Goods>> result = new Result<List<Goods>>();
        try {
            result.setCode(200);
            result.setDesc("success");
            result.setData(goodsMapper.selectList(Wrappers.lambdaQuery()));
        } catch (Exception ex) {
            result.setCode(201);
            result.setDesc(ex.getMessage());
        }
        return result;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result<Goods> getGoods(@PathVariable("id") String id) {
        Result<Goods> result = new Result<>();
        try {
            result.setCode(200);
            result.setDesc("success");
            result.setData(goodsMapper.selectById(id));
        } catch (Exception e) {
            result.setCode(201);
            result.setDesc(e.getMessage());
        }
        return result;
    }
}
