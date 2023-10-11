package Droid;

import java.util.List;

public class Ranger extends Droid{
    private final int rangerChance = 10;
    public Ranger(String name) {
        super.name = name;
        super.health = 100;
        super.damage = 15;
        super.evasion = 0;
        super.evadChance = 0;
    }
    @Override
    public void uniqueAbility(List<Droid> teammates, List<Droid> enemies) {
        if(super.random.nextInt(100) <= rangerChance) {
            for(Droid droid: enemies) {
                double actualDamage = this.damage - (this.damage * (droid.evasion / 100));
                droid.health -= actualDamage;
                System.out.println("Droid " + droid.name + " has taken " + this.damage);
                if(droid.health <= 0) {
                    enemies.remove(droid);
                    System.out.println("Droid " + droid.name + " died");
                }
            }
            System.out.println("Ranger attack all enemy!");
        } else {
            this.attack(enemies);
        }
    }
}
