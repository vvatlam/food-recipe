package com.in.food.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.food.recipe.entity.Recipe;
import com.in.food.recipe.exceptions.RecipeNotFoundException;
import com.in.food.recipe.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/recipes")
@Api(value="Hotel Management System", description="Operations pertaining to favourite recipes in Hotel Management System")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	
	/* 
	 * List of your Favorite Recipes from Dashboard
	 */
	@GetMapping("/")
	@ApiOperation(value = "View a list of my Favourite Recipes", response = Recipe.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list of favourite recipes"),
			@ApiResponse(code = 401, message = "You are not authorized to view the recipes"),
			@ApiResponse(code = 403, message = "Accessing the recipes you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The Recipe you were trying to reach is not found")
	})
	public List<Recipe> recipesList() {
		return recipeService.recipesList();
	}
	
	/* 
	 * Add your Favorite Recipes to Dashboard
	 */
	@PostMapping("/add")
	@ApiOperation(value = "Add Your Favourite Recipe")
	public Recipe recipeAdd(@RequestBody Recipe recipe) {
		return recipeService.recipeAdd(recipe);
	}
	
	
	/* 
	 * update your Favorite Recipes to Dashboard
	 */
	@PutMapping("/update/{id}")
	@ApiOperation(value = "Update Your Favourite Recipe")
	public Recipe recipeUpdate(@ApiParam(value = "update Recipe with recipe", required = true) @PathVariable("id") Long id, @ApiParam(value = "Update Recipe", required = true) @RequestBody Recipe recipe) throws RecipeNotFoundException {
		return recipeService.recipeUpdate(id, recipe);
	} 
	
	
	
	/* 
	 * Delete your Favorite Recipe from Dashboard
	 */
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete Recipe")
	public ResponseEntity<String> recipeDelete(@ApiParam(value = "Recipe is deleted from Dashboard with RecipeId", required = true) @PathVariable("id") Long recipeId) throws RecipeNotFoundException {
		 Recipe recipe = recipeService.findByRecipeId(recipeId);
		 if(recipe == null) {
			 return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		 }
		 recipeService.recipeDelete(recipeId);
		 
		 return new ResponseEntity<>("RecipeID :" + recipeId + " deleted successfully", HttpStatus.OK);
	}
}
