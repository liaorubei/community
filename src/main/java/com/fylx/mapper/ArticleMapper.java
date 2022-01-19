package com.fylx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fylx.entity.Article;
import com.fylx.vo.ArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {}
