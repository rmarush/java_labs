package Food;

import Enums.Type;

public class Vegetable {
    private String name;
    private int calories;
    private Type type;

    public Vegetable(String name, int calories, Type type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }
    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
