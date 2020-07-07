package com.joaoigm.myrecipes.recipes.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Document(collection = "recipes")
public class Recipe {
    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }

    private Set<Ingredient> ingredients = new HashSet<Ingredient>();
    private Set<Step> steps = new HashSet<Step>();

    private String title;

    public Set<Ingredient> getIngredients(){
        return ingredients;
    }

    public Set<Step> getSteps(){
        return steps;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void generateId(){
        this.id = UUID.randomUUID();
    }

    @JsonCreator
    public Recipe(UUID id, Set<Ingredient> ingredients, Set<Step> steps, String title) {
        this.id = id;
        this.ingredients = ingredients;
        this.steps = steps;
        this.title = title;
    }

    public Recipe(){}
}
