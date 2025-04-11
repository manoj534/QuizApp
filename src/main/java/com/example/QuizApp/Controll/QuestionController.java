package com.example.QuizApp.Controll;

import com.example.QuizApp.Exception.QuestionNotFoundException;
import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Service.QuestionService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/getAll")
    public List<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping("/get/{id}")
    public Question getById(@PathVariable("id") Integer id) throws QuestionNotFoundException { // ✅ Matches "{id}"
        return questionService.getById(id);
    }

    @GetMapping("/category/{cat}")
    public ResponseEntity<List<Question>> getQuestionByCat(@PathVariable String cat){
        return questionService.getByCat(cat);

    }

    @PostMapping("/addQuestion")
    public ResponseEntity<Question> AddQuestion(@RequestBody Question question){

        return questionService.AddQue(question);
    }


}
