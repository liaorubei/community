package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fylx.AjaxResult;
import com.fylx.entity.*;
import com.fylx.mapper.ArticleMapper;
import com.fylx.mapper.GoodsMapper;
import com.fylx.mapper.GroupsMapper;
import com.fylx.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    GroupsMapper groupsMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //@ResponseBody
    @GetMapping("/admin")
    @RequestMapping("/admin/index")
    public String a() {
        return "/admin/admin_index.html";
    }

    @GetMapping("/admin/goods")
    public String goodsIndex(Model model) {
        List<Goods> goods = goodsMapper.selectList(new QueryWrapper<Goods>().orderByAsc("Title"));
        model.addAttribute("goodsList", goods);
        return "/admin/admin_goods_index.html";
    }

    @PostMapping("/admin/goods")
    public String goodsIndex(Integer pageNum, Model model) {
        List<Goods> goods = goodsMapper.selectList(new QueryWrapper<Goods>().orderByAsc("Title"));
        model.addAttribute("goodsList", goods);
        return "/admin/admin_goods_index.html";
    }

    @GetMapping("/admin/goods/create")
    public String goodsCreate(Model model) {
        model.addAttribute("goods", new Goods());
        return "/admin/admin_goods_create.html";
    }

    @GetMapping("/admin/goods/modify/{goodsId}")
    public String goodsModify(@PathVariable String goodsId, Model model) {
        Goods goods = goodsMapper.selectById(goodsId);
        model.addAttribute("goods", goods);
        return "/admin/admin_goods_create.html";
    }

    @ResponseBody
    @PostMapping("/admin/goods/modify")
    public AjaxResult goodsModify(Goods goods) {
        AjaxResult ajax = new AjaxResult();
        try {
            //insert
            if (StringUtils.isEmpty(goods.getId())) {
                goods.setId(UUID.randomUUID().toString().replace("-", ""));
                goodsMapper.insert(goods);
            }
            //update
            else {
                UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
                wrapper.eq("Id", goods.getId());
                wrapper.set("Title", goods.getTitle());
                wrapper.set("Price", goods.getPrice());
                wrapper.set("Url", goods.getUrl());
                wrapper.set("Image", goods.getImage());
                goodsMapper.update(null, wrapper);
            }

            //set result
            ajax.setStatusCode(200);
            ajax.setNavTabId("admin_goods_index");
            ajax.setRel("admin_goods_create");
            ajax.setCallbackType("closeCurrent");
        } catch (Exception ex) {
            ajax.setStatusCode(300);
            ajax.setMessage(ex.getMessage());
        }
        return ajax;
    }

    @ResponseBody
    @PostMapping("/admin/goods/delete/{goodsId}")
    public AjaxResult goodsDelete(@PathVariable String goodsId) {
        //delete
        goodsMapper.deleteById(goodsId);

        //set result
        AjaxResult ajax = new AjaxResult();
        ajax.setStatusCode(200);
        ajax.setNavTabId("admin_goods_index");
        //ajax.setRel("admin_goods_create");
        //ajax.setCallbackType("closeCurrent");
        return ajax;
    }

    @GetMapping("/admin/article")
    public String articleIndex(Model model) {
        List<Article> list = articleMapper.selectList(new QueryWrapper<Article>().eq("Type", 1).or().eq("Type", 2).orderByDesc("CreateAt"));
        model.addAttribute("articleList", list);
        return "/admin/admin_article_index.html";
    }

    @PostMapping("/admin/article")
    public String articleIndex(Integer pageNum, Model model) {
        List<Article> list = articleMapper.selectList(new QueryWrapper<Article>().eq("Type", 1).or().eq("Type", 2).orderByDesc("CreateAt"));
        model.addAttribute("articleList", list);
        return "/admin/admin_article_index.html";
    }

    @GetMapping("/admin/article/create")
    public String articleCreate(Model model) {
        model.addAttribute("modelItem", new Article());
        return "/admin/admin_article_create.html";
    }

    @GetMapping("/admin/article/modify/{articleId}")
    public String articleModify(@PathVariable String articleId, Model model) {
        Article item = articleMapper.selectById(articleId);
        model.addAttribute("modelItem", item);
        return "/admin/admin_article_create.html";
    }

    @ResponseBody
    @PostMapping("/admin/article/modify")
    public AjaxResult articleModify(Article article) {
        AjaxResult ajax = new AjaxResult();
        Date date = new Date();
        try {
            //insert
            if (StringUtils.isEmpty(article.getId())) {
                article.setId(UUID.randomUUID().toString().replace("-", ""));
                article.setCreateAt(sdf.format(date));
                articleMapper.insert(article);
            }
            //update
            else {
                UpdateWrapper<Article> wrapper = new UpdateWrapper<>();
                wrapper.eq("Id", article.getId());
                wrapper.set("Title", article.getTitle());
                wrapper.set("Content", article.getContent());
                wrapper.set("Description", article.getDescription());
                wrapper.set("IsOriginal", article.getIsOriginal());
                wrapper.set("Type", article.getType());
                wrapper.set("Url", article.getUrl());
                wrapper.set("ModifyAt", sdf.format(date));
                articleMapper.update(null, wrapper);
            }

            //set result
            ajax.setStatusCode(200);
            ajax.setNavTabId("admin_article_index");
            ajax.setRel("admin_article_create");
            ajax.setCallbackType("closeCurrent");
        } catch (Exception ex) {
            ajax.setStatusCode(300);
            ajax.setMessage(ex.getMessage());
        }
        return ajax;
    }

    @ResponseBody
    @PostMapping("/admin/article/delete/{articleId}")
    public AjaxResult articleDelete(@PathVariable String articleId) {
        //delete
        articleMapper.deleteById(articleId);

        //set result
        AjaxResult ajax = new AjaxResult();
        ajax.setStatusCode(200);
        ajax.setNavTabId("admin_article_index");
        //ajax.setRel("admin_article_create");
        //ajax.setCallbackType("closeCurrent");
        return ajax;
    }

    /*--------------group--------------*/

    @GetMapping("/admin/group")
    public String groupIndex(Model model) {
        List<Group> list = groupsMapper.selectList(null);
        model.addAttribute("modelItems", list);
        return "/admin/admin_group_index.html";
    }

    @PostMapping("/admin/group")
    public String groupIndex(Integer pageNum, Model model) {
        List<Group> list = groupsMapper.selectList(null);
        model.addAttribute("modelItems", list);
        return "/admin/admin_group_index.html";
    }

    @GetMapping("/admin/group/edit")
    public String groupEdit(Model model) {
        Group item = new Group();
        model.addAttribute("modelItem", item);
        return "/admin/admin_group_edit.html";
    }

    @GetMapping("/admin/group/edit/{id}")
    public String groupEdit(@PathVariable String id, Model model) {
        Group item = groupsMapper.selectById(id);
        model.addAttribute("modelItem", item);
        return "/admin/admin_group_edit.html";
    }

    @ResponseBody
    @PostMapping("/admin/group/edit")
    public AjaxResult groupEdit(Group group, HttpServletRequest request) {
        MultipartHttpServletRequest k = (MultipartHttpServletRequest) request;
        if (StringUtils.isEmpty(group.getId())) {
            group.setId(UUID.randomUUID().toString().replace("-", ""));
            groupsMapper.insert(group);
        }
        //update
        else {
            groupsMapper.updateById(group);
        }

        //set result
        AjaxResult result = new AjaxResult();
        result.setStatusCode(200);
        result.setNavTabId("admin_group_index");
        result.setCallbackType("closeCurrent");
        return result;
    }

    @ResponseBody
    @PostMapping("/admin/group/delete/{id}")
    public AjaxResult groupDelete(@PathVariable String id) {
        //delete
        groupsMapper.deleteById(id);

        //set result
        AjaxResult result = new AjaxResult(200);
        result.setNavTabId("admin_group_index");
        return result;
    }

    /*--------------question--------------*/

    @GetMapping("/admin/question")
    public String questionIndex(Model model) {
        List<Article> list = articleMapper.selectList(new QueryWrapper<Article>().eq("Type", 3).orderByDesc("CreateAt"));
        model.addAttribute("modelItems", list);
        return "/admin/admin_question_index.html";
    }

    @PostMapping("/admin/question")
    public String questionIndex(Integer pageNum, Model model) {
        List<Article> list = articleMapper.selectList(new QueryWrapper<Article>().eq("Type", 3).orderByDesc("CreateAt"));
        model.addAttribute("modelItems", list);
        return "/admin/admin_question_index.html";
    }

    @GetMapping("/admin/question/edit")
    public String questionEdit(Model model) {
        Article item = new Article();
        List<Group> groups = groupsMapper.selectList(null);
        model.addAttribute("groups", groups);
        model.addAttribute("modelItem", item);
        return "/admin/admin_question_edit.html";
    }

    @GetMapping("/admin/question/edit/{id}")
    public String questionEdit(@PathVariable String id, Model model) {
        Article item = articleMapper.selectById(id);
        List<Group> groups = groupsMapper.selectList(null);
        model.addAttribute("groups", groups);
        model.addAttribute("modelItem", item);
        return "/admin/admin_question_edit.html";
    }

    @ResponseBody
    @PostMapping("/admin/question/edit")
    public AjaxResult questionEdit(Article article, HttpServletRequest request) {
        article.setType(3);
        article.setCreateAt(sdf.format(new Date()));
        if (StringUtils.isEmpty(article.getId())) {
            article.setId(UUID.randomUUID().toString().replace("-", ""));
            articleMapper.insert(article);
        }
        //update
        else {
            articleMapper.updateById(article);
        }

        //set result
        AjaxResult result = new AjaxResult();
        result.setStatusCode(200);
        result.setNavTabId("admin_question_index");
        result.setCallbackType("closeCurrent");
        return result;
    }

    @ResponseBody
    @PostMapping("/admin/question/delete/{id}")
    public AjaxResult questionDelete(@PathVariable String id) {
        //delete
        articleMapper.deleteById(id);

        //set result
        AjaxResult result = new AjaxResult(200);
        result.setNavTabId("admin_question_index");
        return result;
    }


    @GetMapping("/article/wrapper/{id}")
    public String articleWrapper(@PathVariable String id, Model model) {
        Article item = articleMapper.selectById(id);
        model.addAttribute("modelItem", item);
        return "/admin/admin_article_wrapper.html";
    }

    @GetMapping("/admin/login")
    public String loginGet(HttpServletRequest request) {
        //return "/AdminLTE-3.0.1/index.html";
        //return "/templates/index.html";
        return "/admin/admin_login.html";
    }

    //@ResponseBody
    @PostMapping("/admin/login")
    public String c(@RequestParam String username, @RequestParam String password) {
        try {
            //用户认证信息
            User user = new User(username, password);

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(usernamePasswordToken);
            //return "/admin/admin_index.html";
            return "redirect:/admin/index";
        } catch (Exception ex) {
            return "/admin/admin_login.html";
        }
    }

    //@ResponseBody
    @GetMapping("/admin/logout")
    public String b(HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/admin/admin_login.html";
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
