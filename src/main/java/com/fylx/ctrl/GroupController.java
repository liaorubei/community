package com.fylx.ctrl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fylx.Result;
import com.fylx.entity.Group;
import com.fylx.mapper.GroupsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    GroupsMapper groupsMapper;

    @GetMapping()
    public Result<List<Group>> list() {
        List<Group> groups = groupsMapper.selectList(null);
        Result<List<Group>> result = new Result<>();
        result.setCode(200);
        result.setData(groups);
        return result;
    }

    @GetMapping("/{id}")
    public Result<Group> getById(@PathVariable String id) {
        Group group = groupsMapper.selectById(id);
        Result<Group> result = new Result<>();
        result.setCode(200);
        result.setData(group);
        return result;
    }

    @PutMapping("/{id}")
    public Result<Group> updateById(@PathVariable String id, Group group) {
        UpdateWrapper<Group> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("Id", id);
        updateWrapper.set("Description", group.getDescription());
        updateWrapper.set("Avatar", group.getAvatar());
        updateWrapper.set("Leader", group.getLeader());
        groupsMapper.update(null, updateWrapper);

        Group group1 = groupsMapper.selectById(id);
        Result<Group> result = new Result<>();
        result.setCode(200);
        result.setData(group1);
        return result;
    }

    @PostMapping("/apply")
    public String apply(String userId, String groupId) {

        return "";
    }
}
