package Droid;

import java.util.List;

public class Healer extends Droid{
    private final int globalHeal = 25;
    private final int globalHealChance = 15;
    public Healer(String name) {
        super.name = name;
        super.health = 100;
        super.damage = 10;
        super.evasion = 5;
        super.evadChance = 5;
    }
    @Override
    public void uniqueAbility(List<Droid> teammates, List<Droid> enemies) {
        if(super.random.nextInt(100) <= globalHealChance) {
            for(Droid droid: teammates) {
                droid.health += globalHeal;
                if(droid.health > 100) {
                    droid.health = 100;
                }
            }
            System.out.println("Healer " + this.name + " heals all teammates +" + globalHeal + "hp");
        }
        this.attack(enemies);
    }
}
