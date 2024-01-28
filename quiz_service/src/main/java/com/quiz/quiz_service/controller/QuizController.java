package com.quiz.quiz_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.quiz_service.model.Question;
import com.quiz.quiz_service.model.Quiz;
import com.quiz.quiz_service.service.QuizService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public String getMethodName(@RequestParam String caty,@RequestParam int numq,@RequestParam String title) {
        return quizService.createQuiz(caty,numq,title);
    }
    
    @GetMapping("display/{id}")
    public List<Question> display_quiz(@PathVariable int id){
        return quizService.display_quiz(id);
    }
    
}
