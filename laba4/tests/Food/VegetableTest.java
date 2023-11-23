package Food;

import org.junit.Test;
import Enums.Type;
import static org.junit.Assert.*;

public class VegetableTest {

    @Test
    public void testGetCalories() {
        Vegetable vegetable = new Vegetable("Carrot", 41, Type.ROOT_VEGETABLES);
        assertEquals(41, vegetable.getCalories());
    }

    @Test
    public void testGetType() {
        Vegetable vegetable = new Vegetable("Broccoli", 55, Type.CRUCIFEROUS_VEGETABLES);
        assertEquals(Type.CRUCIFEROUS_VEGETABLES, vegetable.getType());
    }

    @Test
    public void testToString() {
        Vegetable vegetable = new Vegetable("Spinach", 7, Type.LEAFY_GREENS);
        assertEquals("Vegetable{name='Spinach', calories=7}", vegetable.toString());
    }

    @Test
    public void testGetName() {
        Vegetable vegetable = new Vegetable("Onion", 40, Type.ALLIUM_VEGETABLES);
        assertEquals("Onion", vegetable.getName());
    }

    @Test
    public void testSetName() {
        Vegetable vegetable = new Vegetable("Bell Pepper", 30, Type.PEPPERS);
        vegetable.setName("Red Bell Pepper");
        assertEquals("Red Bell Pepper", vegetable.getName());
    }
}