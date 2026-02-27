package com.back.spring_pratice;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키
    private int id;

    private String subject;
    private String content;

    @OneToMany(mappedBy = "question2") // mappedBy를 적은 쪽은 외래키가 생성되지 않는다.
    private List<Answer> answerList = new ArrayList<>();
}
