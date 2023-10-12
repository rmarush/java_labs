package Droid;

import java.util.List;

public class Asassin extends Droid{
    private final int criticalDamage = 15;
    private final int crirticalChange = 15;

    public Asassin(String name) {
        super.name = name;
        super.health = 100;
        super.damage = 15;
        super.evasion = 15;
        super.evadChance = 15;
    }

    @Override
    public void uniqueAbility(List<Droid> teammates, List<Droid> enemies) {
        if(random.nextInt(100) <= crirticalChange) {
            Droid enemy = enemies.get(random.nextInt(enemies.size()));
            double actualDamage = this.damage + random.nextInt(criticalDamage) - (this.damage * (enemy.evasion / 100));
            enemy.health -= actualDamage;
            System.out.println("Assasin " + name + " make cricital damage " + actualDamage + " to the droid " + enemy.name);
            if(enemy.health <= 0) {
                enemies.remove(enemy);
                System.out.println("Droid " + enemy.name + " died");
            }
        } else {
            this.attack(enemies);
        }
    }
}
