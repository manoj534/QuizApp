package com.example.QuizApp.Respository;

import com.example.QuizApp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
