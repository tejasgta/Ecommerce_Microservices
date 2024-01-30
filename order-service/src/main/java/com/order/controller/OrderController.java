package com.order.controller;

import com.order.entity.Answer;
import com.order.entity.Question;
import com.order.service.AnswerService;
import com.order.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;

	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from Order Service";
	}

	@GetMapping("/question")
	public ResponseEntity<List<Question>> getQuestions(){
		return new ResponseEntity<>(questionService.getQuestions(), HttpStatus.OK);
	}

	@PostMapping("/question")
	public Question saveQuestion(@RequestBody Question question){
		return questionService.saveQuestion(question);
	}

	@GetMapping("/answer")
	public ResponseEntity<List<Answer>> getAnswers(){
		return new ResponseEntity<>(answerService.getAnswers(), HttpStatus.OK);
	}

	@PostMapping("/answer")
	public Answer saveAnswer(@RequestBody Answer answer){
		return answerService.saveAnswer(answer);
	}

}
