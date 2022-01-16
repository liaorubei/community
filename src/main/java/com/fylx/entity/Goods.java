package com.fylx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Goods")
public class Goods {
    //@TableId(type = IdType.AUTO)
    @TableField("Id")
    private String id;

    private String title;
    private Double price;
    private String url;
    private String image;
    private Integer thumb;
}
