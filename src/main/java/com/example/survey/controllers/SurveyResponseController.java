package com.example.survey.controllers;

import com.example.survey.dto.SurveyResponsesDTO;
import com.example.survey.services.SurveyResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/responses")
public class SurveyResponseController {

    @Autowired
    SurveyResponseService surveyResponseService;

    @PostMapping
    public void saveResponses(@RequestBody SurveyResponsesDTO surveyResponsesDTO) {
        this.surveyResponseService.saveResponses(surveyResponsesDTO);
    }
}
