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
    public void sortVegetable() {
        Collections.sort(ingredients, (v1, v2) -> Integer.compare(v1.getCalories(), v2.getCalories()));
    }
    public ArrayList<Vegetable> findVegetableInRange(int minCalories, int maxCalories) {
        ArrayList<Vegetable> result = new ArrayList<>();
        for(Vegetable vegetable : ingredients) {
            int calories = vegetable.getCalories();
            if(calories >= minCalories && calories <= maxCalories) {
                result.add(vegetable);
            }
        }
        return result;
    }
}
