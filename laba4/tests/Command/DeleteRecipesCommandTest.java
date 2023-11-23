package Command;

import Food.Salad;
import Kitchen.Chef;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DeleteRecipesCommandTest {
    private Chef chef;
    private InputStream originalSystemIn;

    @Before
    public void setUp() {
        chef = new Chef(); // Assuming you have a Chef class to test
        originalSystemIn = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testDeleteRecipesCommand_SaladFound() {
        String input = "Caesar Salad\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Salad saladToAdd = new Salad("Caesar Salad");
        chef.recipes.add(saladToAdd);

        DeleteRecipesCommand command = new DeleteRecipesCommand(chef, new Scanner(System.in));
        command.execute();

        Salad deletedSalad = chef.getDeletedSalad();

        assertNotNull(deletedSalad);
        assertEquals("Caesar Salad", deletedSalad.getName());
    }

    @Test
    public void testDeleteRecipesCommand_SaladNotFound() {
        String input = "Greek Salad\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        DeleteRecipesCommand command = new DeleteRecipesCommand(chef, new Scanner(System.in));
        command.execute();

        Salad deletedSalad = chef.getDeletedSalad();

        assertNull(deletedSalad);
    }
}