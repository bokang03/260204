package com.back.spring_pratice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void 전체_조회() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void 질문_subject_일치(){
        Question q1 = questionRepository.findById(1).get();
        assertEquals("sbb가 무엇인가요?", q1.getSubject());
        assertThat(q1.getSubject()).isEqualTo("sbb가 무엇인가요?");
    }


    @Test
    void 질문_인덱스_찾기() {
        Question q1 = questionRepository.findBySubject("sbb가 무엇인가요?").get();
        // select * from question where subject = 'sbb가 무엇인가요?'

        assertThat(q1.getId()).isEqualTo(1);
        assertThat(q1.getContent()).isEqualTo("sbb에 대해서 알고 싶습니다.");
    }

    @Test
    void 질문_수정(){
        Question q1 = questionRepository.findById(1).get();
        q1.setSubject("sbb가 무엇인가요? - 수정");

        questionRepository.save(q1);
        questionRepository.flush(); // 변경 내용을 DB에 즉시 반영

        Question q1_2 = questionRepository.findById(1).get();
        assertThat(q1_2.getSubject()).isEqualTo("sbb가 무엇인가요? - 수정");
    }

    @Test
    void 질문_삭제(){
        Question q1 = questionRepository.findById(1).get();
        questionRepository.delete(q1);

        assertThat(questionRepository.count()).isEqualTo(1); // 2개 였는데 삭제해서 1개가 되었는지
    }

    @Test
    @Transactional
    void 답글_저장(){
        Question q1 = new Question();
        q1.setSubject("새 질문");

        Answer a1 = new Answer();
        a1.setContent("답글 1");

        q1.addAnswer(a1);
        questionRepository.save(q1);
        questionRepository.flush();

        Answer foundedAnswer = answerRepository.findById(1).get();

        assertThat(foundedAnswer.getId()).isEqualTo(1);
        assertThat(foundedAnswer.getContent()).isEqualTo("답글 1");

    }
}
