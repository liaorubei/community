package com.fylx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fylx.entity.Apk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ApkMapper extends BaseMapper<Apk> {
    @Select("select * from Apk order by VersionCode desc limit 1;")
    Apk selectLatest();
}
