package Droid;

import java.util.List;
import java.util.Random;

public abstract class Droid {
    protected  String name;
    protected double health;
    protected double damage;
    protected double evasion;
    protected int evadChance;
    public abstract void uniqueAbility(List<Droid> teammates, List<Droid> enemies);
    protected Random random = new Random();

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public double getEvasion() {
        return evasion;
    }
    public void attack(List<Droid> enemies) {
        Droid enemy = enemies.get(random.nextInt(enemies.size()));
        if(random.nextInt(100) <= evadChance) {
            double actualDamage = this.damage - (this.damage * (enemy.evasion / 100));
            enemy.health -= actualDamage;
            System.out.println("Droid " + enemy.name + " wounded by " + actualDamage);
        }
        else {
            enemy.health -= this.damage;
            System.out.println("Droid " + enemy.name + " wounded by " + this.damage);
        }
        if(enemy.health <= 0) {
            enemies.remove(enemy);
            System.out.println("Droid " + enemy.name + " died");
        }
    }
    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", evasion=" + evasion +
                '}';
    }
}
