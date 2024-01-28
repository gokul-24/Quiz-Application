package com.quiz.question_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.quiz.question_service.model.Question;
import com.quiz.question_service.service.QuestionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService service;

    @GetMapping("all")
    public List<Question> getallquestions() {
        return service.getall();
    }
    @GetMapping("{caty}")
    public List<Question> getCategory(@PathVariable String caty) {
        return service.getCat(caty);
    }
    
    @PostMapping("add")
    public String addQuestion(@RequestBody Question entity) {
        System.out.println("------------------entered-----------------");
        return service.addQuestion(entity);    
    }
    @PostMapping("create")
    public List<Integer> createQuiz(@RequestParam String caty,@RequestParam int numq) {
        return service.createQuiz(caty,numq);
    }
    
    @PostMapping("quizdata")
    public List<Question> getQuestions(@RequestBody List<Integer> ids) {
        return service.getQuestionById(ids);
    }
    
}
