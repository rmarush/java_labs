package Command;

import Kitchen.Chef;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class PrintVegetablesCommandTest {

    private Chef chef;
    private PrintVegetablesCommand command;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        chef = new Chef();
        chef.initializeFromDataFile("D:\\vegetables.txt");
        Scanner scanner = new Scanner(System.in);
        command = new PrintVegetablesCommand(chef, scanner);

        System.setOut(new PrintStream(outputStream));
    }
    @Test
    public void execute() {
        String expected = "Available vegetables list: \r\n" +
                "#1 Vegetable{name='Spinach', calories=7}\r\n" +
                "#2 Vegetable{name='Carrot', calories=41}\r\n" +
                "#3 Vegetable{name='Broccoli', calories=55}\r\n" +
                "#4 Vegetable{name='Onion', calories=40}\r\n" +
                "#5 Vegetable{name='Tomato', calories=18}\r\n" +
                "#6 Vegetable{name='Zucchini', calories=17}\r\n" +
                "#7 Vegetable{name='Bell Pepper', calories=31}\r\n" +
                "#8 Vegetable{name='Lentils', calories=353}\r\n";

        command.execute();

        assertEquals(expected, outputStream.toString());
    }
}