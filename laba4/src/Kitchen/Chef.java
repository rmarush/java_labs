package Kitchen;

import Food.*;
import java.util.ArrayList;

public class Chef {
    ArrayList<Salad> recipes = new ArrayList<Salad>();
    public Salad createSalad(String name) {
        Salad salad = new Salad(name);
        recipes.add(salad);
        return salad;
    }
    public Salad findRecipes(String name) {
        Salad salad = null;
        for(Salad recipe : recipes) {
            if(recipe.getName().equals(name)) {
                salad = recipe;
                System.out.println("do later");
                return salad;
            }
        }
        return null;
    }

}
