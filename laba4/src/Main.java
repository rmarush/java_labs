import Command.Command;
import Kitchen.*;
import Command.*;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Chef chef = new Chef();
        Command command = null;
        chef.initializeFromDataFile("D:\\vegetables.txt");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create a salad" +
                    "\n2. Check recipes" +
                    "\n3. Find recipe by name" +
                    "\n4. Delete recipe by name" +
                    "\n5. Print available vegetables" +
                    "\n6. Find vegetables in range" +
                    "\n7. Sort vegetables in list" +
                    "\n8. End");
            System.out.print("Input a number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    command = new CreateSaladCommand(chef, scanner);
                    break;
                case 2:
                    command = new CheckRecipesCommand(chef, scanner);
                    break;
                case 3:
                    command = new FindRecipeCommand(chef, scanner);
                    break;
                case 4:
                    command = new DeleteRecipesCommand(chef,scanner);
                    break;
                case 5:
                    command = new PrintVegetablesCommand(chef,scanner);
                    break;
                case 6:
                    command = new FindVegetableInRangeCommand(chef, scanner);
                    break;
                case 7:
                    command = new SortVegetableCommand(chef, scanner);
                    break;
                case 8:
                    return;
                default:
                    command = null;
                    System.out.println("Unknown command");
            }
            if(command != null) {
                command.execute();
            }
        }
    }
}

// Шеф-повар. Визначити ієрархію овочів. Зробити салат. Підрахувати калорійність.
// Здійснити сортування овочів для салату на основі одного з параметрів. Знайти овочі
// в салаті, що відповідають заданому діапазону калорійності.