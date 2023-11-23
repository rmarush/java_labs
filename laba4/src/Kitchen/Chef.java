package Kitchen;
import Enums.Type;
import Food.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Chef {
    public ArrayList<Salad> recipes = new ArrayList<Salad>();
    public static ArrayList<Vegetable> vegetables = new ArrayList<>();
    private Salad deletedSalad;

    public Chef() {
    }

    public static ArrayList<Vegetable> getVegetables() {
        return vegetables;
    }


    public static void setVegetables(ArrayList<Vegetable> vegetables) {
        Chef.vegetables = vegetables;
    }

    public Salad getDeletedSalad() {
        return deletedSalad;
    }

    public void initializeFromDataFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int calories = Integer.parseInt(parts[1]);
                    Type type = Type.valueOf(parts[2]);
                    vegetables.add(new Vegetable(name, calories, type));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Salad createSalad(String name, Scanner scanner) {
        Salad salad = new Salad(name);
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
                deletedSalad = recipe;
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
    public ArrayList<Vegetable> findVegetableInRange(int minCalories, int maxCalories, String saladName) {
        ArrayList<Vegetable> result = new ArrayList<>();
        Salad foundSalad = null;
        for (Salad salad : recipes) {
            if (salad.getName().equals(saladName)) {
                foundSalad = salad;
                break;
            }
        }
        if(foundSalad == null) {
            return result;
        }
        for(Vegetable vegetable : foundSalad.getVegetables()) {
            int calories = vegetable.getCalories();
            if(calories >= minCalories && calories <= maxCalories) {
                result.add(vegetable);
            }
        }
        return result;
    }

    public Salad getSaladByName(String name) {
        if (recipes == null) {
            return null;
        }

        Optional<Salad> foundSalad = recipes.stream()
                .filter(salad -> salad.getName().equals(name))
                .findFirst();

        return foundSalad.orElse(null);
    }

}
