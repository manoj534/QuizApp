package com.example.QuizApp.Controll;

import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Model.QuizWrapper;
import com.example.QuizApp.Model.Response;
import com.example.QuizApp.Service.QuizService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQ, @RequestParam String title){

        return quizService.createQ(category, noOfQ, title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuizWrapper>> getQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> calculateResul(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizService.calculateResult(id,response);


    }
}
