package com.example.QuizApp.Service;

import com.example.QuizApp.Exception.QuestionNotFoundException;
import com.example.QuizApp.Model.Question;
import com.example.QuizApp.QuestionServ;
import com.example.QuizApp.Respository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements QuestionServ {

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public List<Question> getAll() {

        System.out.println(questionRepo.findAll());
        return questionRepo.findAll();

      //  return List.of();
    }

    @Override
    public Question getById(Integer Id) throws QuestionNotFoundException {

        Optional<Question> question = questionRepo.findById(Id);
        if(question.isEmpty()){
            throw new QuestionNotFoundException("didn't fond the question with Id"+Id);
        }
        return question.get();
    }

    @Override
    public ResponseEntity<List<Question>> getByCat(String cat) {
        return new ResponseEntity<>(questionRepo.findBycategory(cat), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Question> AddQue(Question question) {
        return new ResponseEntity<>(questionRepo.save(question), HttpStatus.CREATED);
    }
}
