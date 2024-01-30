package com.order.service;

import com.order.entity.Answer;
import com.order.entity.Question;
import com.order.repository.AnswerRepository;
import com.order.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repo;
    public Question saveQuestion(Question ques){
        return repo.save(ques);
    }

    public List<Question> getQuestions(){
        return repo.findAll();
    }
}
