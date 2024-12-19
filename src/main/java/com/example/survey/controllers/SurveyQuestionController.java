package com.example.survey.controllers;

import com.example.survey.models.SurveyQuestion;
import com.example.survey.services.SurveyQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class SurveyQuestionController {

    @Autowired
    SurveyQuestionService surveyQuestionService;

    @PostMapping
    public SurveyQuestion createQuestion(@RequestBody SurveyQuestion question) {
        return this.surveyQuestionService.createQuestion(question);
    }

    @GetMapping("/{surveyId}")
    public List<SurveyQuestion> getAllQuestionsBySurveyId(@PathVariable String surveyId) {
        return this.surveyQuestionService.findAllByIdSurvey(Long.parseLong(surveyId));
    }
}
