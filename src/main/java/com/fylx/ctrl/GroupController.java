package com.fylx.ctrl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {

    @PostMapping("/apply")
    public String apply(String userId, String groupId) {


        return "";
    }
}
