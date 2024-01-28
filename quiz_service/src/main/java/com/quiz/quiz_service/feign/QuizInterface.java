package com.quiz.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.quiz_service.model.Question;


@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @PostMapping("question/create")
    public List<Integer> createQuiz(@RequestParam String caty,@RequestParam int numq);
    
    @PostMapping("question/quizdata")
    public List<Question> getQuestions(@RequestBody List<Integer> ids);
}
