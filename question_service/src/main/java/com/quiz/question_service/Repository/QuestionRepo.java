package com.quiz.question_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.question_service.model.Question;
import java.util.List;


@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM Question q WHERE q.category = :caty ORDER BY RANDOM() LIMIT :numq",nativeQuery=true)
    List<Integer> createQuiz(String caty, int numq);
} 