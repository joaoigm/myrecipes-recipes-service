package com.joaoigm.myrecipes.recipes.service.repositories;

import com.joaoigm.myrecipes.recipes.service.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface IRecipeRepository extends CrudRepository<Recipe, Integer> {
}
