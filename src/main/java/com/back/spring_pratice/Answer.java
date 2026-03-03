package com.back.spring_pratice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String subject;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}
