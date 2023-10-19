package Command;
import java.util.Scanner;
import Food.*;
import Kitchen.Chef;

public class CreateSaladCommand implements Command{
    private Chef chef;
    private Scanner scanner;

    public CreateSaladCommand(Chef chef, Scanner scanner) {
        this.chef = chef;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Input the name of the salad to add: ");
        String name = scanner.nextLine();
        Salad salad = chef.createSalad(name, scanner);
        System.out.println("Salad '" + name + "' is created.");
    }
}
