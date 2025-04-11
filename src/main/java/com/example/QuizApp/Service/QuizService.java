package com.example.QuizApp.Service;

import com.example.QuizApp.Model.Question;
import com.example.QuizApp.Model.Quiz;
import com.example.QuizApp.Model.QuizWrapper;
import com.example.QuizApp.Model.Response;
import com.example.QuizApp.Respository.QuestionRepo;
import com.example.QuizApp.Respository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQ(String category, int noOfq, String title){

        List<Question> questionList = questionRepo.findRandomQuestionByCategory(category, noOfq);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        /*Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
*/
        quizRepo.save(quiz);

        return new ResponseEntity<>("succes", HttpStatus.OK);

    }

    public ResponseEntity<List<QuizWrapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionList = quiz.get().getQuestionList();
        List<QuizWrapper> quizWrapperList = new ArrayList<>();
        for(Question q: questionList){
            QuizWrapper quizWrapper = new QuizWrapper(q.getOption4(), q.getQuestionTitle(), q.getOption1(),q.getOption2(),q.getOption3(),q.getId());
            quizWrapperList.add(quizWrapper);
        }
        return new ResponseEntity<>(quizWrapperList,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionList = quiz.get().getQuestionList();
        int right = 0;
        int i = 0;

        System.out.println("hello");

        for(Response r: responses){
            if(r.getRightAnswer().equals(questionList.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
