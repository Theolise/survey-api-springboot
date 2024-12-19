package com.example.survey.controllers;

import com.example.survey.models.Survey;
import com.example.survey.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    @GetMapping
    public List<Survey> getAllSurveys() {
        return this.surveyService.getAllSurveys();
    }

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return this.surveyService.createSurvey(survey);
    }
}
