package com.fylx.service;

import com.fylx.dto.QuestionDto;
import com.fylx.entity.Question;
import com.fylx.entity.User;
import com.fylx.mapper.QuestionMapper;
import com.fylx.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    public List<QuestionDto> list() {
        List<QuestionDto> result = new ArrayList<>();
        List<Question> questions = questionMapper.list();
        for (Question question : questions) {
            QuestionDto dto = new QuestionDto();
            BeanUtils.copyProperties(question, dto);
            User user = userMapper.getById(question.getCreateBy());
            dto.setUser(user);
            result.add(dto);
        }
        return result;
    }
}
