package com.fylx.ctrl;

import com.fylx.Result;
import com.fylx.entity.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@RestController
public class GoodsController {

    @Value("${filepath}")
    private String filepath;

    @ResponseBody
    @GetMapping(value = "goods")
    public Result<Goods> getGoods() {
        Result<Goods> result = new Result<>();
        result.setData(new Goods());

        try {
            File folder=new File(filepath);
            if (!folder.exists()){
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
