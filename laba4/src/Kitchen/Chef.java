package Kitchen;
import Enums.Type;
import Food.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Chef {
    private ArrayList<Salad> recipes = new ArrayList<Salad>();
    private  ArrayList<Vegetable> vegetables = new ArrayList<>(
            Arrays.asList(
                    new Vegetable("Spinach", 7, Type.LEAFY_GREENS),
                    new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES),
                    new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES),
                    new Vegetable("Onion", 40, Type.ALLIUM_VEGETABLES),
                    new Vegetable("Tomato", 18, Type.NIGHTSHADE_VEGETABLES),
                    new Vegetable("Zucchini", 17, Type.GOURD_AND_SQUASH_VEGETABLES),
                    new Vegetable("Bell Pepper", 31, Type.PEPPERS),
                    new Vegetable("Lentils", 353, Type.LEGUMES)
            )
    );
    public Chef() {
    }
    public Salad createSalad(String name, Scanner scanner) {
        Salad salad = new Salad(name);
        System.out.println("Available vegetable list: ");
        printVegetables();
        while(true) {
            System.out.print("Input what you want to add: ");
            switch(scanner.nextInt()) {
                case 1:
                    salad.addVegetable(vegetables.get(0));
                    break;
                case 2:
                    salad.addVegetable(vegetables.get(1));
                    break;
                case 3:
                    salad.addVegetable(vegetables.get(2));
                    break;
                case 4:
                    salad.addVegetable(vegetables.get(3));
                    break;
                case 5:
                    salad.addVegetable(vegetables.get(4));
                    break;
                case 6:
                    salad.addVegetable(vegetables.get(5));
                    break;
                case 7:
                    salad.addVegetable(vegetables.get(6));
                    break;
                case 8:
                    salad.addVegetable(vegetables.get(7));
                    break;
                case 9:
                    recipes.add(salad);
                    return salad;
            }
        }

    }
    public Salad deleteRecipes(String name) {
        for(Salad recipe : recipes) {
            if(recipe.getName().equals(name)) {
                recipes.remove(recipe);
                return recipe;
            }
        }
        return null;
    }
    public void checkRecipes() {
        for(Salad recipe : recipes) {
            System.out.println("Recipe " + recipe.getName() + " has a " + recipe.calculateCalories() + " calories" +
                    "\nConsist of: ");
            recipe.printIngredients();
        }
    }
    public Salad findRecipe(String name) {
        for (Salad recipe : recipes) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }
    public void printVegetables() {
        int i = 1;
        System.out.println("Available vegetables list: ");
        for(Vegetable ingridient : vegetables) {
            System.out.println("#" + i++ + " " + ingridient);
        }
    }
    public void sortVegetable() {
        Collections.sort(vegetables, (v1, v2) -> Integer.compare(v1.getCalories(), v2.getCalories()));
    }
    public ArrayList<Vegetable> findVegetableInRange(int minCalories, int maxCalories) {
        ArrayList<Vegetable> result = new ArrayList<>();
        for(Vegetable vegetable : vegetables) {
            int calories = vegetable.getCalories();
            if(calories >= minCalories && calories <= maxCalories) {
                result.add(vegetable);
            }
        }
        return result;
    }
}
