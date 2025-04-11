package com.example.QuizApp.Model;

import lombok.Data;

@Data
public class Response {


    private Integer id;

    private String rightAnswer;

    public Response(String rightAnswer, Integer id) {
        this.rightAnswer = rightAnswer;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
