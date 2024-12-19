package com.example.survey.controllers;

import com.example.survey.models.SurveyResult;
import com.example.survey.services.SurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class SurveyResultController {

    @Autowired
    SurveyResultService resultService;

    @GetMapping("/{surveyId}")
    public List<SurveyResult> getResultsBySurveyId(@PathVariable String surveyId) {
        return resultService.findAllBySurveyId(Long.parseLong(surveyId));
    }
}
