package com.order.service;

import com.order.entity.Answer;
import com.order.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repo;
    public Answer saveAnswer(Answer ans){
        return repo.save(ans);
    }

    public List<Answer> getAnswers(){
        return repo.findAll();
    }
}
