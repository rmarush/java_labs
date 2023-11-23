package Food;
import Enums.Type;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SaladTest {

    private Salad salad;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        salad = new Salad("Test Salad");
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddVegetable() {
        Vegetable carrot = new Vegetable("Carrot", 50, Type.ROOT_VEGETABLES);
        salad.addVegetable(carrot);

        assertEquals(1, salad.getVegetables().size());
        assertTrue(salad.getVegetables().contains(carrot));
    }

    @Test
    public void printIngredients() {
        Vegetable carrot = new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES);
        Vegetable broccoli = new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES);
        salad.addVegetable(carrot);
        salad.addVegetable(broccoli);

        int totalCalories = salad.calculateCalories();

        assertEquals(96, totalCalories);
    }

    @Test
    public void testCalculateCaloriesEmptySalad() {
        int totalCalories = salad.calculateCalories();

        assertEquals(0, totalCalories);
    }

    @Test
    public void testPrintIngredients() {
        Vegetable carrot = new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES);
        Vegetable broccoli = new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES);
        salad.addVegetable(carrot);
        salad.addVegetable(broccoli);

        salad.printIngredients();

        String expectedOutput = "#1 Vegetable{name='Carrot', calories=41}\r\n" +
                "#2 Vegetable{name='Broccoli', calories=55}\r\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}