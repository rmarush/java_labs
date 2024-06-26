package org.example.Food;

import java.util.ArrayList;

public class Salad {
    private String name;
    private ArrayList<Vegetable> ingredients = new ArrayList<>();

    public Salad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIngredients(ArrayList<Vegetable> ingredients) {
        this.ingredients = ingredients;
    }

    public void addVegetable(Vegetable vegetable) {
        ingredients.add(vegetable);
    }
    public ArrayList<Vegetable> getVegetables() {
        return ingredients;
    }
    public  void printIngredients() {
        int i = 1;
        for(Vegetable ingredient : ingredients) {
            System.out.println("#" + i++ + " " + ingredient);

        }
    }
    public int calculateCalories() {
        int totalCalories = 0;
        if(ingredients.isEmpty()) {
            return 0;
        }
        for(Vegetable vegetable : ingredients) {
            totalCalories += vegetable.getCalories();
        }
        return totalCalories;
    }
}
