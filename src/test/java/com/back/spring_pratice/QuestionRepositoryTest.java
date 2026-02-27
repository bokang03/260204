package com.back.spring_pratice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void t1() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

//    @Test
//    @Transactional
//    void t2() {
//        Question q1 = questionRepository.findById(1).get();
//        System.out.println(q1.getSubject());
//        System.out.println(q1.getContent());
//
//        // q1 질문에 대한 답글
//        List<Answer> answers = q1.getAnswerList();
//
//        for (Answer a : answers) {
//            System.out.println(a.getContent());
//        }
//
//    }

}