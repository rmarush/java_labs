package Command;

import Food.Salad;
import Kitchen.Chef;

import java.util.Scanner;

public class PrintVegetablesCommand implements Command{
    private Chef chef;
    private Scanner scanner;

    public PrintVegetablesCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        chef.printVegetables();
    }
}
