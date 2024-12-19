package com.example.survey.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "survey_responses")
public class SurveyResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_survey", nullable = false)
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "id_question", nullable = false)
    private SurveyQuestion question;

    @Column(nullable = false)
    private Integer score;

    public SurveyResponse() {}

    public SurveyResponse(Survey survey, SurveyQuestion question, Integer score) {
        this.survey = survey;
        this.question = question;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
