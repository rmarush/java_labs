import Droid.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    private final List<Droid> teammates = new ArrayList<Droid>();
    private final List<Droid> enemies = new ArrayList<Droid>();
    private final Random random = new Random();
    private final Scanner in = new Scanner(System.in);
    public void startBattle() {
        boolean turn = random.nextBoolean();
        while(!teammates.isEmpty() && !enemies.isEmpty()) {
            if(turn == true) {
                teammates.get(random.nextInt(teammates.size())).uniqueAbility(teammates, enemies);
            } else {
                enemies.get(random.nextInt(enemies.size())).uniqueAbility(enemies, teammates);
            }
            turn = random.nextBoolean();
            showDroidHP();
        }
        if (teammates.isEmpty()) {
            System.out.println("Darkness team win!");
        } else {
            System.out.println("Radiance team win!");
        }
    }
    public void addDroid(Team team) {
        Droid droid = null;
        System.out.print("Input the name for your droid: ");
        String name = in.nextLine();
        System.out.println("Input the number of droid which you want to add: " +
                "\n1 - Asassin droid" +
                "\n2 - Healer droid" +
                "\n3 - Gunner droid" +
                "\n4 - Ranger droid");
        switch (in.nextInt()) {
            case 1:
                droid = new Asassin(name);
                break;
            case 2:
                droid = new Healer(name);
                break;
            case 3:
                droid = new Gunner(name);
                break;
            case 4:
                droid = new Ranger(name);
                break;
            default:
                System.out.println("Input error, try again!");
                break;
        }
        in.nextLine();
        if(droid == null) {
            return;
        }
        if(team == Team.Radiance) {
            teammates.add(droid);
        } else {
            enemies.add(droid);
        }
    }
    public void deleteDroid(Team team) {
        System.out.print("Input a droid name for delete: ");
        String name = in.nextLine();

        if (team == Team.Radiance) {
            teammates.removeIf(droid -> droid.getName().equals(name));
        } else {
            enemies.removeIf(droid -> droid.getName().equals(name));
        }
    }
    private void printDroidList(List<Droid> droids) {
        for (Droid droid : droids)
            System.out.print(droid.getName() + " ");
    }

    public void printDroidsFromTeam(Team team){
        System.out.println("Droid list: ");
        if (team == Team.Radiance) {
            printDroidList(teammates);
        }
        else {
            printDroidList(enemies);
        }
        System.out.println();
    }
    public void showDroidHP() {
        System.out.println("Radiance team: ");
        for(Droid droid : teammates) {
            System.out.println(droid.getName() + " has " + droid.getHealth() + "hp");
        }
        System.out.println("Darkness team: ");
        for(Droid droid : enemies) {
            System.out.println(droid.getName() + " has " + droid.getHealth() + "hp");
        }
    }
}
