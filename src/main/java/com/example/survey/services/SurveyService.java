package com.example.survey.services;

import com.example.survey.models.Survey;
import com.example.survey.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    SurveyRepository surveyRepository;

    public Optional<Survey> findById(long id) {
        return this.surveyRepository.findById(id);
    }

    public List<Survey> getAllSurveys() {
        return this.surveyRepository.findAll();
    }

    public Survey createSurvey(Survey survey) {
        return this.surveyRepository.save(survey);
    }
}
