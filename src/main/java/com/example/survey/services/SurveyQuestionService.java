package com.example.survey.services;

import com.example.survey.models.SurveyQuestion;
import com.example.survey.repositories.SurveyQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionService {

    @Autowired
    SurveyQuestionRepository surveyQuestionRepository;

    public Optional<SurveyQuestion> findById(long id) {
        return this.surveyQuestionRepository.findById(id);
    }

    public SurveyQuestion createQuestion(SurveyQuestion question) {
        return this.surveyQuestionRepository.save(question);
    }

    public List<SurveyQuestion> findAllByIdSurvey(long surveyId) {
        return this.surveyQuestionRepository.findBySurveyIdOrderByOrderNumber(surveyId);
    }
}
