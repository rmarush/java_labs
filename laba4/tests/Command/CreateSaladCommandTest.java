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

public class CreateSaladCommandTest {
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
    public void testCreateSaladCommand() {
        String input = "Caesar Salad\n9\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        CreateSaladCommand command = new CreateSaladCommand(chef, new Scanner(System.in));
        command.execute();


        Salad createdSalad = chef.getSaladByName("Caesar Salad");

        assertNotNull(createdSalad);
        assertEquals("Caesar Salad", createdSalad.getName());
    }
}