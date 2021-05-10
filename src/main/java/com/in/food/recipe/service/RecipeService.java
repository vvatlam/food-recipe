package com.in.food.recipe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.food.recipe.entity.Recipe;
import com.in.food.recipe.exceptions.RecipeNotFoundException;
import com.in.food.recipe.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	/* 
	 * Service call for getting all recipes from Dashboard
	 */
	public List<Recipe> recipesList() {
		return recipeRepository.findAll();
	}

	/* 
	 * Service call for adding recipes to Dashboard
	 */
	public Recipe recipeAdd(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public Recipe findByRecipeId(Long recipeId)  throws RecipeNotFoundException{
		return recipeRepository.findById(recipeId).orElseThrow(() -> new RecipeNotFoundException("Recipe not found for this id :: " + recipeId));
	}

	/* 
	 * Service call for deleting recipes from Dashboard
	 */
	public void recipeDelete(Long recipeId) {
	       recipeRepository.deleteById(recipeId);		
	}

	/* 
	 * Service call for updating recipes to Dashboard
	 */
	public Recipe recipeUpdate(Long id, Recipe recipe) throws RecipeNotFoundException {
		Optional<Recipe> currentRecipe = recipeRepository.findById(id);
		
		if(currentRecipe.isPresent()) {
			Recipe _recipe = currentRecipe.get();
			_recipe.setName(recipe.getName());
			_recipe.setVegan(recipe.isVegan());
			_recipe.setInstructions(recipe.getInstructions());
			_recipe.setServings(recipe.getServings());
			_recipe.setCreated(recipe.getCreated());
			_recipe.setIngredients(recipe.getIngredients());
			
			
			return recipeRepository.save(_recipe);
		}
		
		return recipeRepository.save(recipe);
	}

}
