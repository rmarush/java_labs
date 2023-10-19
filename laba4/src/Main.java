import Command.Command;
import Kitchen.*;
import Command.*;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Chef chef = new Chef();
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
                    Command createSaladCommand = new CreateSaladCommand(chef, scanner);
                    createSaladCommand.execute();
                    break;
                case 2:
                    Command checkRecipesCommand = new CheckRecipesCommand(chef, scanner);
                    checkRecipesCommand.execute();
                    break;
                case 3:
                    Command findRecipeCommand = new FindRecipeCommand(chef, scanner);
                    findRecipeCommand.execute();
                    break;
                case 4:
                    Command deleteRecipesCommand = new DeleteRecipesCommand(chef,scanner);
                    deleteRecipesCommand.execute();
                    break;
                case 5:
                    Command printVegetablesCommand = new PrintVegetablesCommand(chef,scanner);
                    printVegetablesCommand.execute();
                    break;
                case 6:
                    Command findVegetableInRangeCommand = new FindVegetableInRangeCommand(chef, scanner);
                    findVegetableInRangeCommand.execute();
                    break;
                case 7:
                    Command sortVegetableCommand = new SortVegetableCommand(chef, scanner);
                    sortVegetableCommand.execute();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}

// Шеф-повар. Визначити ієрархію овочів. Зробити салат. Підрахувати калорійність.
// Здійснити сортування овочів для салату на основі одного з параметрів. Знайти овочі
// в салаті, що відповідають заданому діапазону калорійності.