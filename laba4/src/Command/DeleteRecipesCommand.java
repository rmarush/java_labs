package Command;

import Food.Salad;
import Kitchen.Chef;

import java.util.Scanner;

public class DeleteRecipesCommand implements Command {
    private Chef chef;
    private Scanner scanner;

    public DeleteRecipesCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Input the name of the salad to delete: ");
        String name = scanner.nextLine();
        Salad salad = chef.deleteRecipes(name);
        if(salad != null) {
            System.out.println("Salad is deleted.");
        } else {
            System.out.println("Salad not found.");
        }
    }
}
