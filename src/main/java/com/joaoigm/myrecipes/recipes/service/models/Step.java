package com.joaoigm.myrecipes.recipes.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Embeddable
public class Step {

    private String description;
    private String expectedResult;
    private Integer days;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtectedResult() {
        return expectedResult;
    }

    public void setExtectedResult(String extectedResult) {
        this.expectedResult = extectedResult;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @JsonCreator
    public Step(String description, String expectedResult, Integer days, Integer hours, Integer minutes, Integer seconds) {
        this.description = description;
        this.expectedResult = expectedResult;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Step(){}
}
