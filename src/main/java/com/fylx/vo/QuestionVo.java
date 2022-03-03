package com.fylx.vo;

import com.fylx.entity.Question;
import com.fylx.entity.User;
import lombok.Data;

@Data
public class QuestionVo extends Question {
    private User creator;
}
