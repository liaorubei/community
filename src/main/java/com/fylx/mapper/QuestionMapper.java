package com.fylx.mapper;

import com.fylx.entity.Question;
import org.apache.ibatis.annotations.*;

@Mapper
public interface QuestionMapper {
    @Insert("insert into Question(Id,Title,Description,Tag,CreateAt,ModifyAt,CreateBy) values(#{id},#{title},#{description},#{tag},#{createAt},#{modifyAt},#{createBy});")
    void insert(Question question);

    @Select("select * from Question where Id=#{id}")
    Question selectById(@Param("id") String id);

    @Delete("delete from Question where id=#{id}")
    void deleteById(String id);
}
