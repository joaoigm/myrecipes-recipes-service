package com.joaoigm.myrecipes.recipes.service.controllers;


import com.joaoigm.myrecipes.recipes.service.models.Ingredient;
import com.joaoigm.myrecipes.recipes.service.models.Recipe;
import com.joaoigm.myrecipes.recipes.service.models.Step;
import com.joaoigm.myrecipes.recipes.service.repositories.IRecipeRepository;
import com.joaoigm.myrecipes.recipes.service.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping("/api/recipes")
public class RecipesController {
    @Autowired
    private IRecipeRepository recipeRepository;
    private UserServices userServices = new UserServices();

    @GetMapping
    public ResponseEntity<Iterable<Recipe>> getRecipes(@RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            return ResponseEntity.ok(recipeRepository.findAll());
        }
        return ResponseEntity.status(401).body(null);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") Integer id, @RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            return ResponseEntity.ok(recipeRepository.findById(id).get());
        }
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("/{id}/steps")
    public
    ResponseEntity<Set<Step>> getRecipeSteps(@PathVariable("id") Integer id, @RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            return ResponseEntity.ok(recipeRepository.findById(id).get().getSteps());
        }
        return ResponseEntity.status(401).body(null);
    }

    @GetMapping("/{id}/ingredients")
    public
    ResponseEntity<Set<Ingredient>> getRecipeIngredients(@PathVariable("id") Integer id, @RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            return ResponseEntity.ok(recipeRepository.findById(id).get().getIngredients());
        }
        return ResponseEntity.status(401).body(null);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe, @RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            recipeRepository.save(recipe);
            return ResponseEntity.ok(recipeRepository.findById(recipe.getId()).get());
        }
        return ResponseEntity.status(401).body(null);
    }

    @PutMapping
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe, @RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            recipeRepository.save(recipe);
            return ResponseEntity.ok(recipeRepository.findById(recipe.getId()).get());
        }
        return ResponseEntity.status(401).body(null);

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Object deleteRecipe(@PathVariable("id")Integer id, @RequestHeader(value = "user-id", defaultValue = "0") Integer userId){
        if(userServices.CheckUserAutenticated(userId)){
            if(!recipeRepository.existsById(id)){ return Collections.singletonMap("message", "User with id "+id+" doesn't exist"); }
            recipeRepository.deleteById(id);
            return Collections.singletonMap("message", "User deleted successful");
        }
        return Collections.singletonMap("message", "Unauthorized");
    }

}