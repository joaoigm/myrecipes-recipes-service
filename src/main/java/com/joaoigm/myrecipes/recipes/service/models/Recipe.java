package com.joaoigm.myrecipes.recipes.service.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "recipe_ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "recipe_steps", joinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Step> steps = new HashSet<Step>();

    @Column(unique = true)
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

    @JsonCreator
    public Recipe(int id, Set<Ingredient> ingredients, Set<Step> steps, String title) {
        this.id = id;
        this.ingredients = ingredients;
        this.steps = steps;
        this.title = title;
    }

    public Recipe(){}
}
