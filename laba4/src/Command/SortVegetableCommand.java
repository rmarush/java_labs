package Command;

import Kitchen.Chef;

import java.util.Scanner;

public class SortVegetableCommand implements Command{
    private Chef chef;
    private Scanner scanner;

    public SortVegetableCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        chef.sortVegetable();
        chef.printVegetables();
    }
}