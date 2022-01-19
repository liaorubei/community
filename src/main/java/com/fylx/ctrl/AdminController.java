package com.fylx.ctrl;

import com.fylx.entity.User;
import com.fylx.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {
    @Autowired
    UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/admin/index")
    public String a() {
        return "/admin/index";
    }

    @GetMapping("/admin/login")
    public String cc() {
        //return "/AdminLTE-3.0.1/index.html";
        return "/templates/index.html";
    }

    //@ResponseBody
    @PostMapping("/admin/login")
    public String c(@RequestParam String username, @RequestParam String password) {
        //用户认证信息

        User user = new User(username, password);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(usernamePasswordToken);

        return "/admin/login";
    }

    @ResponseBody
    @RequestMapping("/admin/logout")
    public String b() {
        return "/admin/logout";
    }

    @RequiresRoles("admin")
    @ResponseBody
    @RequestMapping("/admin/articles")
    public String d() {
        return "/admin/index";
    }

    @RequiresPermissions("insert")
    @ResponseBody
    @RequestMapping("/admin/articles/{id}")
    public String e(@PathVariable("id") String id) {
        return "/admin/index";
    }

    @RequiresRoles("admin1")
    @ResponseBody
    @RequestMapping("/admin/index1")
    public String f() {
        return "/admin/index1";
    }

    @RequiresPermissions("update")
    @ResponseBody
    @RequestMapping("/admin/index2")
    public String g() {
        return "/admin/index2";
    }
}
