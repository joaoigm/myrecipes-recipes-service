package com.joaoigm.myrecipes.recipes.service.repositories;

import com.joaoigm.myrecipes.recipes.service.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IRecipeRepository extends MongoRepository<Recipe, UUID> {
}
