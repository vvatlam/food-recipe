package com.in.food.recipe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "INGREDIENTS")
public class Ingredients {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;
	private String ingredientsList;
	
	public Ingredients() {
		super();
	}


	public Ingredients(Long id, String ingredientsList) {
		this.id = id;
		this.ingredientsList = ingredientsList;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIngredientsList() {
		return ingredientsList;
	}

	public void setIngredientsList(String ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	
	

	
}
