package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fylx.Result;
import com.fylx.entity.User;
import com.fylx.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping()
    public Result<User> getUser(String username, String password) {
        Result<User> result = new Result<>();
        result.setCode(200);
        try {
            User user = userMapper.selectOne(new QueryWrapper<User>().eq("Username", username));
            if (user == null) throw new Exception("不存在该用户");
            if (!user.getPassword().equals(password)) throw new Exception("用户名或密码不正确");
            result.setCode(200);
            result.setDesc("success");
        } catch (Exception ex) {
            result.setDesc(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/a")
    public String kkk() {
        return "";
    }
}
