package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fylx.dto.QuestionDto;
import com.fylx.entity.User;
import com.fylx.mapper.UserMapper;
import com.fylx.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {


        List<QuestionDto> questions = questionService.list();
        model.addAttribute("questions", questions);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Boolean remember,
                        HttpServletRequest request, HttpServletResponse response) {

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        User user = userMapper.selectOne(wrapper.eq(User::getUsername, username));
        if (null != user && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
        }

        if (remember) {
            Cookie cookie = new Cookie("username", username);
            Cookie cookie1 = new Cookie("password", password);
            response.addCookie(cookie);
            response.addCookie(cookie1);
        }

        return "redirect:index";
    }

    @RequestMapping("github/callback")
    public String callback(String code, String state) {


        return "";
    }


}
