package Command;

import Enums.Type;
import Food.Vegetable;
import Kitchen.Chef;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SortVegetableCommandTest {

    private Chef chef;
    private SortVegetableCommand command;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        chef = new Chef();
        chef.initializeFromDataFile("D:\\vegetables.txt");
        Scanner scanner = new Scanner(System.in);
        command = new SortVegetableCommand(chef, scanner);

        System.setOut(new PrintStream(outputStream));
    }
    @Test
    public void execute() {
        // Arrange
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(new Vegetable("Spinach",7, Type.LEAFY_GREENS));
        vegetables.add(new Vegetable("Onion",40,Type.ALLIUM_VEGETABLES));
        vegetables.add(new Vegetable("Tomato",18,Type.NIGHTSHADE_VEGETABLES));
        chef.setVegetables(vegetables);

        // Actual
        command.execute();

        // Assert
        assertEquals("Spinach", vegetables.get(0).getName());
        assertEquals("Tomato", vegetables.get(1).getName());
        assertEquals("Onion", vegetables.get(2).getName());
    }
}