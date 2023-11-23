package Command;

import Food.Vegetable;
import Kitchen.Chef;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FindVegetableInRangeCommandTest {
    private Chef chef;
    private InputStream originalSystemIn;

    @Before
    public void setUp() {
        chef = new Chef();
        originalSystemIn = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testFindVegetableInRangeCommand() {
        String input = "SaladABC\n40\n50\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        FindVegetableInRangeCommand command = new FindVegetableInRangeCommand(chef, new Scanner(System.in));
        command.execute();

        ArrayList<Vegetable> result = chef.findVegetableInRange(40, 50, "SaladABC");

        assertNotNull(result);

    }
}