package Droid;

import java.util.List;

public class Gunner extends Droid{
    private final int gunnerChance = 10;
    public Gunner(String name) {
        super.name = name;
        super.health = 100;
        super.damage = 20;
        super.evasion = 25;
        super.evadChance = 25;
    }

    @Override
    public void uniqueAbility(List<Droid> teammates, List<Droid> enemies) {
        if(random.nextInt(100) <= gunnerChance) {
            for(Droid droid: enemies) {
                this.attack(enemies);
            }
            System.out.println("Gunner " + this.name + " made a series of attacks!");
        } else {
            this.attack(enemies);
        }
    }
}
