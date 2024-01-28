package com.quiz.quiz_service.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import com.quiz.quiz_service.feign.QuizInterface;
import com.quiz.quiz_service.Repository.QuizRepo;
import com.quiz.quiz_service.model.Question;
import com.quiz.quiz_service.model.Quiz;

@Service
public class QuizService {

    @Autowired
    QuizRepo create_quiz1;

    @Autowired
    private DiscoveryClient discoveryClient;
    //QuizInterface quizInterface;
    public String createQuiz(String caty, int numq, String title) {
        
        /*List<Integer> ids = quizInterface.createQuiz(caty, numq);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionids(ids);
        create_quiz1.save(quiz);*/
        List<ServiceInstance> list = discoveryClient.getInstances("QUESTION-SERVICE");
        if (list != null && list.size() > 0 ) {
            URI uri =  list.get(0).getUri();
            return uri.toString();
        }

        return "failed";
    }
    public List<Question> display_quiz(int id) {
        /*Quiz q=create_quiz1.findById(id).get();
        List<Integer> ids = q.getQuestionids();

        return quizInterface.getQuestions(ids);*/
        return new ArrayList<Question>();
    }
    
}
