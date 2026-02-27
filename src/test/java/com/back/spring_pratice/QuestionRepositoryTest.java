package com.back.spring_pratice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void t1() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        questionRepository.save(q1);

        Answer a1 = new Answer();
        a1.setSubject("sbb는 스프링부트 게시판입니다.1");
        a1.setQuestion(q1);
        answerRepository.save(a1);

        Answer a2 = new Answer();
        a2.setSubject("sbb는 스프링부트 게시판입니다.2");
        a2.setQuestion(q1);
        answerRepository.save(a2);

    }

    @Test
    @Transactional
    void t2() {
        Question q1 = questionRepository.findById(1).get();
        System.out.println(q1.getSubject());
        System.out.println(q1.getContent());

        // q1 질문에 대한 답글
        List<Answer> answers = q1.getAnswerList();

        for (Answer a : answers) {
            System.out.println(a.getContent());
        }

    }

}