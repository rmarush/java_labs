package Command;

import Enums.Type;
import Food.Salad;
import Food.Vegetable;
import Kitchen.Chef;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FindRecipeCommandTest {
    private Chef chef;
    private FindRecipeCommand command;
    private InputStream originalSystemIn;
    private PrintStream originalSystemOut;

    @Before
    public void setUp() {
        chef = new Chef(); // Assuming you have a Chef class to test
        originalSystemIn = System.in;
        originalSystemOut = System.out;
    }

    @Test
    public void testFindRecipeCommand_RecipeFound() {
        String input = "Caesar Salad\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Salad saladToAdd = new Salad("Caesar Salad");
        chef.recipes.add(saladToAdd);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        command = new FindRecipeCommand(chef, new Scanner(System.in));
        command.execute();

        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);

        String actualOutput = outputStream.toString().trim();

        String expectedOutput = "Input the name of the salad to search: Found a salad recipe 'Caesar Salad";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFindRecipeCommand_RecipeNotFound() {
        String input = "Greek Salad\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        command = new FindRecipeCommand(chef, new Scanner(System.in));

        command.execute();

        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);

        String actualOutput = outputStream.toString().trim();

        assertTrue(actualOutput.contains("Recipe not found."));
    }
}