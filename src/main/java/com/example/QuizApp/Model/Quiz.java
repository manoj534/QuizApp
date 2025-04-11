package com.example.QuizApp.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Setter
@Getter
public class Quiz {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Title;

    @ManyToMany
    private List<Question> QuestionList;*/
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

    private String title;

    @ManyToMany
    private List<Question> questionList;

    // Manually add setter and getter for testing
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
