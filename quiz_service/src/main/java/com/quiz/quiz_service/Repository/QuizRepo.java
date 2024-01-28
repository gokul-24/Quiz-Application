package com.quiz.quiz_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quiz_service.model.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

    
} 