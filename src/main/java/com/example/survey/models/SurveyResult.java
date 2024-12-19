package com.example.survey.models;

import jakarta.persistence.*;

@Entity
@Table(name = "survey_results")
public class SurveyResult {

    @EmbeddedId
    private SurveyResultKey id;

    @ManyToOne
    @MapsId("surveyId")
    @JoinColumn(name = "id_survey", nullable = false)
    private Survey survey;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "id_question", nullable = false)
    private SurveyQuestion question;

    @Column(name = "score_average", nullable = false)
    private Double scoreAverage;

    @Column(name = "score_sum", nullable = false)
    private Integer scoreSum;

    @Column(name = "number_response", nullable = false)
    private Integer numberResponse;

    public SurveyResult() {
    }

    public SurveyResult(Survey survey, SurveyQuestion question, Double scoreAverage, Integer scoreSum, Integer numberResponse) {
        this.id = new SurveyResultKey(survey.getId(), question.getId());
        this.survey = survey;
        this.question = question;
        this.scoreAverage = scoreAverage;
        this.scoreSum = scoreSum;
        this.numberResponse = numberResponse;
    }

    public SurveyResultKey getId() {
        return id;
    }

    public void setId(SurveyResultKey id) {
        this.id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public SurveyQuestion getQuestion() {
        return question;
    }

    public void setQuestion(SurveyQuestion question) {
        this.question = question;
    }

    public Double getScoreAverage() {
        return scoreAverage;
    }

    public void setScoreAverage(Double scoreAverage) {
        this.scoreAverage = scoreAverage;
    }

    public Integer getScoreSum() {
        return scoreSum;
    }

    public void setScoreSum(Integer scoreSum) {
        this.scoreSum = scoreSum;
    }

    public Integer getNumberResponse() {
        return numberResponse;
    }

    public void setNumberResponse(Integer numberResponse) {
        this.numberResponse = numberResponse;
    }
}
