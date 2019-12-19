package com.fylx.ctrl;

import com.fylx.dto.QuestionDto;
import com.fylx.entity.User;
import com.fylx.mapper.UserMapper;
import com.fylx.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {

                    String token = cookie.getValue();
                    User user = userMapper.getByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        List<QuestionDto> questions = questionService.list();
        model.addAttribute("questions", questions);
        return "index";
    }


    @RequestMapping("github/callback")
    public String callback(String code, String state) {


        return "";
    }


}
