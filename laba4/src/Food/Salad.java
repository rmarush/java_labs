package Food;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;
import java.util.ListIterator;

public class Salad {
    private String name;
    private ArrayList<Vegetable> ingredients = new ArrayList<>();

    public Salad(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addVegetable(Vegetable vegetable) {
        ingredients.add(vegetable);
    }
    public  void printIngredients() {
        int i = 1;
        for(Vegetable ingredient : ingredients) {
            System.out.println("#" + i++ + " " + ingredient + "\n");

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
