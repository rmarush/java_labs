package Kitchen;

import Food.Salad;
import Food.Vegetable;
import Enums.Type;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ChefTest {

    private Chef chef;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() {
        chef = new Chef();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCreateSalad() {
        Scanner scanner = new Scanner(System.in);
        Salad salad = new Salad("Test Salad");

        assertNotNull(salad);
        assertEquals("Test Salad", salad.getName());
        assertEquals(0, salad.getVegetables().size());
    }
    @Test
    public void testDeleteRecipes() {
        Salad salad = new Salad("Test Salad");
        chef.recipes.add(salad);

        Salad deletedSalad = chef.deleteRecipes("Test Salad");

        assertNotNull(deletedSalad);
        assertEquals("Test Salad", deletedSalad.getName());
        assertEquals(0, chef.recipes.size());
    }

    @Test
    public void testFindRecipe() {
        Salad salad = new Salad("Test Salad");
        chef.recipes.add(salad);

        Salad foundSalad = chef.findRecipe("Test Salad");

        assertNotNull(foundSalad);
        assertEquals("Test Salad", foundSalad.getName());
    }
    @Test
    public void testFindVegetableInRange() {
        Salad salad = new Salad("Test Salad");
        ArrayList<Vegetable> saladVegetables = new ArrayList<>();
        saladVegetables.add(new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES));
        saladVegetables.add(new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES));
        saladVegetables.add(new Vegetable("Onion", 40, Type.NIGHTSHADE_VEGETABLES));
        salad.setIngredients(saladVegetables);
        chef.recipes.add(salad);

        ArrayList<Vegetable> result = chef.findVegetableInRange(35, 50, "Test Salad");

        assertEquals(2, result.size());
        assertEquals("Carrot", result.get(0).getName());
        assertEquals("Onion", result.get(1).getName());
    }


    @Test
    public void testSortVegetable() {
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES));
        vegetables.add(new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES));
        vegetables.add(new Vegetable("Onion", 40, Type.NIGHTSHADE_VEGETABLES));
        chef.setVegetables(vegetables);

        chef.sortVegetable();

        ArrayList<Vegetable> sortedVegetables = chef.vegetables;
        assertEquals(40, sortedVegetables.get(0).getCalories());
        assertEquals(41, sortedVegetables.get(1).getCalories());
        assertEquals(55, sortedVegetables.get(2).getCalories());
    }

    @Test
    public void testPrintVegetables() {
        ArrayList<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES));
        vegetables.add(new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES));
        vegetables.add(new Vegetable("Onion", 40, Type.NIGHTSHADE_VEGETABLES));

        chef.setVegetables(vegetables);

        chef.printVegetables();

        String expectedOutput = "Available vegetables list: \r\n" +
                "#1 Vegetable{name='Carrot', calories=41}\r\n" +
                "#2 Vegetable{name='Broccoli', calories=55}\r\n" +
                "#3 Vegetable{name='Onion', calories=40}\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    public void testInitializeFromDataFile() throws IOException {
        chef.setVegetables(new ArrayList<Vegetable>());
        chef.initializeFromDataFile("D:\\vegetables.txt");

        ArrayList<Vegetable> vegetables = chef.getVegetables();
        assertEquals(8, vegetables.size());

        Vegetable carrot = vegetables.get(0);
        assertEquals("Spinach", carrot.getName());
        assertEquals(7, carrot.getCalories());
        assertEquals(Type.LEAFY_GREENS, carrot.getType());

        Vegetable broccoli = vegetables.get(1);
        assertEquals("Carrot", broccoli.getName());
        assertEquals(41, broccoli.getCalories());
        assertEquals(Type.ROOT_VEGETABLES, broccoli.getType());

        Vegetable pepper = vegetables.get(2);
        assertEquals("Broccoli", pepper.getName());
        assertEquals(55, pepper.getCalories());
        assertEquals(Type.CRUCIFEROUS_VEGETABLES, pepper.getType());
    }

    @Test
    public void testGetSaladByName_SaladFound() {
        Salad saladToAdd = new Salad("Caesar Salad");
        chef.recipes.add(saladToAdd);

        Salad foundSalad = chef.getSaladByName("Caesar Salad");

        assertNotNull(foundSalad);
        assertEquals("Caesar Salad", foundSalad.getName());
    }

    @Test
    public void testGetSaladByName_SaladNotFound() {
        Salad foundSalad = chef.getSaladByName("Greek Salad");

        assertNull(foundSalad);
    }
}