package com.example.survey.services;

import com.example.survey.models.Survey;
import com.example.survey.models.SurveyQuestion;
import com.example.survey.models.SurveyResult;
import com.example.survey.models.SurveyResultKey;
import com.example.survey.repositories.SurveyResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyResultService {

    @Autowired
    SurveyResultRepository surveyResultRepository;

    public Optional<SurveyResult> findById(Survey survey, SurveyQuestion question) {
        SurveyResultKey key = new SurveyResultKey(survey.getId(), question.getId());

        return surveyResultRepository.findById(key);
    }

    public List<SurveyResult> findAllBySurveyId(long surveyId) {
        return surveyResultRepository.findBySurveyId(surveyId);
    }

    public SurveyResult saveSurveyResult(SurveyResult result) {
        return surveyResultRepository.save(result);
    }
}
