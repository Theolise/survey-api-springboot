package com.example.survey.repositories;

import com.example.survey.models.SurveyResult;
import com.example.survey.models.SurveyResultKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyResultRepository extends JpaRepository<SurveyResult, SurveyResultKey> {
    List<SurveyResult> findBySurveyId(long surveyId);
}
