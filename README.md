# food-recipe
Favorite Recipe application to add, update, delete the recipes

## favourite-recipes
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
Create a single‐page web application which allows users to manage your favourite recipes.
Use a dashboard to show all available recipes and the actions to create, update and delete a recipe.
When the user selects a recipe the application should display on the same screen the following attributes:
 * Date and time of creation (formatted as dd‐MM‐yyyy HH:mm);
 * Indicator if the dish is vegetarian;
 * Indicator displaying the number of people the dish is suitable for;
 * Display ingredients as a list;
 * Cooking instructions;
## Technologies
* Java 11
* Spring Boot 2.4.5
* Rest API
* Maven
* Junit5
## Setup
### Use the webbapp
#### * Create your Favrorite Recipe
##### Requested Url : http://localhost:9002/recipes   <br/>
##### Request json :
```
{
  "created": "2021-05-10T04:16:17.481Z",
  "id": 0,
  "ingredients": [
    {
      "ingredientsList": "1 teaspoon (4 grams) baking powder"
    },
	 {
      "ingredientsList": "2 cups (300 grams) fresh blueberries (one dry pint)"
    },
	 {
      "ingredientsList": "1 cup (225 grams) unsalted butter, at room temperature"
    }
  ],
  "instructions": "1 1/4 cups (150 grams) confectioners sugar (powdered or icing sugar), sifted",
  "name": "Blueberry Pound Cake",
  "recipeId": 0,
  "servings": 1,
  "vegan": true
}
``` 
#### * Get all your Favorite Recipes 
##### Requested URL : http://localhost:9002/recipes/ <br/>
##### Response Code : 200 (Successfully retrieved list of favourite recipes)

#### * Update your Favorite Recipes
##### Requeste URL: http://localhost:9002/recipes/1 <br/>
##### Request Json:
```
{
  "created": "2021-05-10T04:16:17.481Z",
  "id": 0,
  "ingredients": [
    {
      "ingredientsList": "1 teaspoon (4 grams) baking powder"
    },
	 {
      "ingredientsList": "2 cups (300 grams) fresh blueberries (one dry pint)"
    },
	 {
      "ingredientsList": "1 cup (225 grams) unsalted butter, at room temperature"
    }
  ],
  "instructions": "1 1/4 cups (150 grams) confectioners sugar (powdered or icing sugar), sifted",
  "name": "Blueberry Pound Cake",
  "recipeId": 0,
  "servings": 1,
  "vegan": true
}
```

#### * Delete you Recipes
##### @ Requested URL:  http://localhost:9002/recipes/1   <br/>
##### Response : 200 ( successfull Deleted your recipe)


### SWagger URL
```
http://localhost:9002/swagger-ui.html#/ 
```
