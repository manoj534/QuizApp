package com.example.QuizApp.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
/*@Table(name = "question")
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String question_title;
   private String option1;
   private String option2;
   private String option3;
   private String option4;
   private String right_answer;
   private String difficulty_level;
   private String category;


   @Override
   public String toString() {
      return "Question{" +
              "id=" + id +
              ", question_title='" + question_title + '\'' +
              ", option1='" + option1 + '\'' +
              ", option2='" + option2 + '\'' +
              ", option3='" + option3 + '\'' +
              ", option4='" + option4 + '\'' +
              ", right_answer='" + right_answer + '\'' +
              ", difficulty_level='" + difficulty_level + '\'' +
              ", category='" + category + '\'' +
              '}';
   }
}*/

public class Question {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String questionTitle;
   private String option1;
   private String option2;
   private String option3;
   private String option4;
   private String rightAnswer;
   private String difficultyLevel;
   private String category;

   @JsonProperty("id")
   public Integer getId() { return id; }

   @JsonProperty("question_title")
   public String getQuestionTitle() { return questionTitle; }

   @JsonProperty("option_1")
   public String getOption1() { return option1; }

   @JsonProperty("option_2")
   public String getOption2() { return option2; }

   @JsonProperty("option_3")
   public String getOption3() { return option3; }

   @JsonProperty("option_4")
   public String getOption4() { return option4; }

   @JsonProperty("right_answer")
   public String getRightAnswer() { return rightAnswer; }

   @JsonProperty("difficulty_level")
   public String getDifficultyLevel() { return difficultyLevel; }

   @JsonProperty("category")
   public String getCategory() { return category; }
}

