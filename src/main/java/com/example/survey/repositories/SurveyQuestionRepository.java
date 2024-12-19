package com.example.survey.repositories;

import com.example.survey.models.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion, Long> {
    List<SurveyQuestion> findBySurveyIdOrderByOrderNumber(@Param("surveyId") Long surveyId);
}
