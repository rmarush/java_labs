package Command;

import Food.Salad;
import Kitchen.Chef;

import java.util.Scanner;

public class CheckRecipesCommand implements Command{
    private Chef chef;
    private Scanner scanner;

    public CheckRecipesCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }
    @Override
    public void execute() {
        System.out.println("List of recipes: ");
        chef.checkRecipes();
    }
}
