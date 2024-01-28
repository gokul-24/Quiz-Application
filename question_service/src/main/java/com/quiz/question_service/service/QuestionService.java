package com.quiz.question_service.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.question_service.Repository.QuestionRepo;
import com.quiz.question_service.model.Question;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo ques;
    public List<Question> getall() {
        return ques.findAll();
    }
    public List<Question> getCat(String caty) {
        return ques.findByCategory(caty);
    }
    public String addQuestion(Question entity) {
        System.out.println("service entered---------------------");
        ques.save(entity);
        return "Success";
    }
    public List<Integer> createQuiz(String caty, int numq) {
        return ques.createQuiz(caty, numq);   
    }
    public List<Question> getQuestionById(List<Integer> ids) {
        List<Question> questions = ques.findAllById(ids); 
        return questions;
    }

}
