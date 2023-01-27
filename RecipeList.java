/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
import java.util.ArrayList;

public class RecipeList {

    private ArrayList<Recipe> recipeList;

    public RecipeList() {
        this.recipeList = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        this.recipeList.add(recipe);
    }

    public void printRecipeList() {
        for (Recipe recipe : recipeList) {
            System.out.println(recipe);
        }
    }

    public void findRecipe(String search) {
        for (Recipe recipe : recipeList) {
            if (recipe.getName().contains(search)) {
                System.out.println(recipe);
            }
        }
    }

    public void findCookingTime(int maxTime) {
        for (Recipe recipe : recipeList) {
            if (recipe.getTime() <= maxTime) {
                System.out.println(recipe);
            }
        }
    }

    public void findIngredient(String ingredient) {
        for (Recipe recipe : recipeList) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }
}
