package org.example.Command;

import org.example.Food.Salad;
import org.example.Kitchen.Chef;

import java.util.Scanner;

public class FindRecipeCommand implements Command {
    private Chef chef;
    private Scanner scanner;

    public FindRecipeCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Input the name of the salad to search: ");
        String name = scanner.nextLine();
        Salad recipe = chef.findRecipe(name);
        if (recipe != null) {
            System.out.println("Found a salad recipe '" + name);
            recipe.printIngredients();
        } else {
            System.out.println("Recipe not found.");
        }
    }
}