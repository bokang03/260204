package com.back.spring_pratice;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String subject;

    @ManyToOne
    private Question question2;
}
