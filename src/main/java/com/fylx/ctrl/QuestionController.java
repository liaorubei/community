package com.fylx.ctrl;

import com.fylx.Result;
import com.fylx.dto.CommentDto;
import com.fylx.entity.Comment;
import com.fylx.entity.Question;
import com.fylx.entity.User;
import com.fylx.mapper.CommentMapper;
import com.fylx.mapper.QuestionMapper;
import com.fylx.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private CommentMapper commentMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publish() {
        return "publish";
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public String publish(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String tag,
            HttpServletRequest request,
            Model model) {


        //数据回填
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        //todo数据非空验证

        User user = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    user = userMapper.getByToken(cookie.getValue());
                    break;
                }
            }
        }

        if (null == user) {
            model.addAttribute("error", "还没有登录");
            return "publish";
        }


        Question question = new Question();
        question.setId(UUID.randomUUID().toString().replace("-", ""));
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        String format = sdf.format(new Date());
        question.setCreateAt(format);
        question.setModifyAt(format);
        question.setCreateBy("");

        //添加人员


        questionMapper.insert(question);


        return "redirect:/";
    }

    @RequestMapping("/question")
    public String kkkkkkkk() {
        return "question";
    }

    @ResponseBody
    @PostMapping(value = "/comment")
    public Result comment(@RequestBody CommentDto commentDto) {
        Result result = new Result();
        Comment entity = new Comment();
        entity.setCreateBy("1");
        entity.setCreateAt(new Date());
        entity.setLikeCount(0);
        BeanUtils.copyProperties(commentDto, entity);
        int insert = commentMapper.insert(entity);
        if (insert > 0) {
            result.setCode(200);
            result.setDesc("保存成功");
        } else {
            result.setCode(-1);
            result.setDesc("保存失败");
        }
        return result;
    }

}
