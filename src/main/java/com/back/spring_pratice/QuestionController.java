package com.back.spring_pratice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    @GetMapping("/question/list")
    public String list(Model model) {

        List<Question> questionList = questionRepository.findAll();

        model.addAttribute("myAge", 20);
        model.addAttribute("questionList", questionList);

        return "question_list";
    }
}