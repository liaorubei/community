package com.fylx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fylx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("selectById * from User")
    List<User> getUsers();


    @Select("selectById * from User where token=#{token}")
    User getUserByToken(@Param("token") String token);
}
