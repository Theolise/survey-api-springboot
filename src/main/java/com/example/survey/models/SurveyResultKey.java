package com.example.survey.models;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SurveyResultKey implements Serializable {

    private Long surveyId;
    private Long questionId;

    public SurveyResultKey() {}

    public SurveyResultKey(Long surveyId, Long questionId) {
        this.surveyId = surveyId;
        this.questionId = questionId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyResultKey that = (SurveyResultKey) o;
        return Objects.equals(surveyId, that.surveyId) && Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyId, questionId);
    }
}
