package com.example.survey.models;

import jakarta.persistence.*;

@Entity
@Table(name = "survey_questions")
public class SurveyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_survey", nullable = false)
    private Survey survey;

    @Column(nullable = false, length = 500)
    private String label;

    @Column(nullable = false)
    private Integer orderNumber;

    public SurveyQuestion() {}

    public SurveyQuestion(Survey survey, String label, Integer orderNumber) {
        this.survey = survey;
        this.label = label;
        this.orderNumber = orderNumber;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
