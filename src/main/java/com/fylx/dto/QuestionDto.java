package com.fylx.dto;

import com.fylx.entity.Question;
import com.fylx.entity.User;
import lombok.Data;

@Data
public class QuestionDto extends Question {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
