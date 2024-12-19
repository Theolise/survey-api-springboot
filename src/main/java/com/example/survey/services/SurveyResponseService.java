package com.example.survey.services;

import com.example.survey.dto.ResponseDTO;
import com.example.survey.dto.SurveyResponsesDTO;
import com.example.survey.models.Survey;
import com.example.survey.models.SurveyQuestion;
import com.example.survey.models.SurveyResponse;
import com.example.survey.models.SurveyResult;
import com.example.survey.repositories.SurveyResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SurveyResponseService {

    @Autowired
    SurveyResponseRepository surveyResponseRepository;

    @Autowired
    SurveyService surveyService;

    @Autowired
    SurveyQuestionService questionService;

    @Autowired
    SurveyResultService resultService;

    public void saveResponses(SurveyResponsesDTO surveyResponsesDTO) {
        for (ResponseDTO responseDTO : surveyResponsesDTO.getResponses()) {
            Optional<Survey> survey = surveyService.findById(surveyResponsesDTO.getSurveyId());
            Optional<SurveyQuestion> question = questionService.findById(responseDTO.getQuestionId());
            if (survey.isPresent() && question.isPresent()) {
                this.surveyResponseRepository.save(new SurveyResponse(survey.get(), question.get(), responseDTO.getScore()));

                updateSurveyResult(survey.get(), question.get(), responseDTO.getScore());
            }
        }
    }

    private void updateSurveyResult(Survey survey, SurveyQuestion question, Integer score) {
        Optional<SurveyResult> resultOpt = resultService.findById(survey, question);

        SurveyResult result;
        if (resultOpt.isPresent()) {
            result = resultOpt.get();
            result.setScoreSum(result.getScoreSum() + score);
            result.setNumberResponse(result.getNumberResponse() + 1);
            result.setScoreAverage((double) result.getScoreSum() / result.getNumberResponse());
        } else {
            result = new SurveyResult(survey, question, Double.valueOf(score), score, 1);
        }
        resultService.saveSurveyResult(result);
    }
}
