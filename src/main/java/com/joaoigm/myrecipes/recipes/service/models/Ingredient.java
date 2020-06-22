package com.joaoigm.myrecipes.recipes.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;

@Embeddable
public class Ingredient {

    private String name;
    private String measure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @JsonCreator
    public Ingredient(String name, String measure) {
        this.name = name;
        this.measure = measure;
    }

    public Ingredient(){}
}
