package com.in.food.recipe.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "RECIPE")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private boolean vegan = true;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date created;
	private String instructions;
	private int servings;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private List<Ingredients> ingredients;
	
	
	public Recipe() {
		super();
	}

	public Recipe(String name, boolean vegan, Date created, String instructions, List<Ingredients> ingredients, int servings) {
		super();
		this.name = name;
		this.vegan = vegan;
		this.created = created;
		this.instructions = instructions;
		this.ingredients = ingredients;
		this.servings = servings;
	}

	public Long getId() {
		return id;
	}

	public void setRecipeId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + id + ", name=" + name + ", vegan=" + vegan + ", created=" + created
				+ ", instructions=" + instructions + ", ingredients=" + ingredients + ", servings=" + servings + "]";
	}
	
}
