package com.example.survey.dto;

import java.util.List;

public class SurveyResponsesDTO {
    private long surveyId;
    private List<ResponseDTO> responses;

    public long getSurveyId() {
        return surveyId;
    }

    public List<ResponseDTO> getResponses() {
        return responses;
    }
}
