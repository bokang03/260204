package com.back.spring_pratice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subject;
    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<Answer> answerList = new ArrayList<>();

    // 이렇게 Question 내부에 메서드를 생성
    public void addAnswer(Answer answer) {
        answer.setQuestion(this);
        answerList.add(answer);
    }
}