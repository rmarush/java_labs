package org.example;

import org.example.Command.*;
import org.example.Kitchen.Chef;

import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Menu {
    private Command command;
    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    public Menu() {
        try {
            FileHandler fileHandler = new FileHandler("app.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Menu(Command command) {
        this.command = command;
    }

    public void execute() {
        Chef chef = new Chef();
        try {
            chef.initializeFromDataFile();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred: " + e.getMessage(), e);
            EmailSender.sendEmail(e.getMessage());
        }
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
            switch (choice) {
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
                    command = new DeleteRecipesCommand(chef, scanner);
                    break;
                case 5:
                    command = new PrintVegetablesCommand(chef, scanner);
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
            if (command != null) {
                try {
                    this.command.execute();
                    logger.log(Level.INFO, "Command executed: " + this.command.getClass().getSimpleName());
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Exception occurred: " + e.getMessage(), e);
                    EmailSender.sendEmail(e.getMessage());
                }
            }
        }
    }
}
