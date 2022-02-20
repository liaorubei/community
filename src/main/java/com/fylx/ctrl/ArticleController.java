package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fylx.Result;
import com.fylx.entity.Article;
import com.fylx.entity.Comment;
import com.fylx.mapper.ArticleMapper;
import com.fylx.mapper.CommentMapper;
import com.fylx.mapper.UserMapper;
import com.fylx.vo.ArticleVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    CommentMapper commentMapper;

    @GetMapping("/articles")
    public Result<List<Article>> getAll(@RequestParam(value = "type", defaultValue = "") Integer type) {
        Result<List<Article>> result = new Result<>();
        try {
            result.setCode(200);
            result.setDesc("success");
            if (type == null)
                result.setData(articleMapper.selectList(Wrappers.lambdaQuery()));
            else {
                result.setData(articleMapper.selectList(new QueryWrapper<Article>().eq("Type", type).orderByDesc("CreateAt")));
            }
        } catch (Exception ex) {
            result.setCode(201);
            result.setDesc(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/articles/{id}")
    public Result<Article> getOne(@PathVariable("id") String id) {
        Result<Article> result = new Result<>();
        try {
            result.setCode(200);
            result.setDesc("success");
            Article data = articleMapper.selectById(id);
            ArticleVo target = new ArticleVo();
            BeanUtils.copyProperties(data, target);
            target.setCreator(userMapper.selectById(target.getCreateBy()));
            target.setComments(commentMapper.selectList(new QueryWrapper<Comment>().eq("ParentId", target.getId())));
            result.setData(target);
        } catch (Exception ex) {
            result.setCode(201);
            result.setDesc(ex.getMessage());
        }
        return result;
    }


}
