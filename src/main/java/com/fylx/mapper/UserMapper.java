package com.fylx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fylx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from User")
    List<User> getUsers();

    @Select("select * from User where token=#{token}")
    User getByToken(@Param("token") String token);

    @Select("select * from User where Id=#{id}")
    User getById(String id);

    @Select("select * from User where Id in(select UserId from GroupsUser where GroupId=#{groupId})")
    List<User> getByGroupId(String groupId);
}
