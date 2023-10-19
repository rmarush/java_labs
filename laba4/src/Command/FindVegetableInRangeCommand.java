package Command;

import Food.Salad;
import Food.Vegetable;
import Kitchen.Chef;

import java.util.ArrayList;
import java.util.Scanner;

public class FindVegetableInRangeCommand implements Command {
    private Chef chef;
    private Scanner scanner;

    public FindVegetableInRangeCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Input a salad name: ");
        String saladName = scanner.nextLine();
        System.out.println("Input a min calories: ");
        int minCalories = scanner.nextInt();
        System.out.println("Input a max calories: ");
        int maxCalories = scanner.nextInt();
        ArrayList<Vegetable> result = chef.findVegetableInRange(minCalories, maxCalories, saladName);
        if(result != null) {
            System.out.println("Vegetables in range {" + minCalories + "; " + maxCalories + "}");
            for(Vegetable vegetable : result) {
                System.out.println(vegetable);
            }
        } else {
            System.out.println("Vegetables not found in range!");
        }
    }
}
