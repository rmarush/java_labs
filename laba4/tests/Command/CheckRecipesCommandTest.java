package Command;

import Food.Salad;
import Kitchen.Chef;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CheckRecipesCommandTest {

    private Chef chef;
    private CheckRecipesCommand command;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        chef = new Chef();
        Scanner scanner = new Scanner(System.in);
        command = new CheckRecipesCommand(chef, scanner);

        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testExecuteWithRecipes() {
        // Arrange
        Salad salad = new Salad("Test Salad");
        chef.recipes.add(salad);
        String expectedOutput = "List of recipes: \r\n" +
                "Recipe Test Salad has a 0 calories\n" +
                "Consist of: \r\n";
        // Actual
        command.execute();
        // Assert
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testExecuteWithoutRecipes() {
        // Arrange
        String expectedOutput = "List of recipes: \r\n";
        // Actual
        command.execute();
        // Assert
        assertEquals(expectedOutput, outputStream.toString());
    }
}