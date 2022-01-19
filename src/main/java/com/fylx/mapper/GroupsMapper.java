package com.fylx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fylx.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupsMapper extends BaseMapper<Group> {

    @Select("select * from Groups where Groups.Id in(select GroupId from GroupsUser where GroupsUser.UserId=#{userId})")
    List<Group> getByUserId(String userId);
}
