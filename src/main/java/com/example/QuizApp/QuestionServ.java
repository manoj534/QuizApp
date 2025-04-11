package com.example.QuizApp;

import com.example.QuizApp.Exception.QuestionNotFoundException;
import com.example.QuizApp.Model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface QuestionServ {

    List<Question> getAll();

    Question getById(Integer Id) throws QuestionNotFoundException;

    ResponseEntity<List<Question>> getByCat(String cat);

    ResponseEntity<Question> AddQue(Question question);
}
