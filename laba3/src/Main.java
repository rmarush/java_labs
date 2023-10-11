import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Battle battle = new Battle();
        while(true) {
            System.out.println("---MAIN MENU---" +
                    "\n1 - Add droid to Radiance" +
                    "\n2 - Add droid to Darkness" +
                    "\n3 - Delete droid from Radiance" +
                    "\n4 - Delete droid from Darkness" +
                    "\n5 - Start battle" +
                    "\n6 - Show Radiance Team" +
                    "\n7 - Show Darkness Team" +
                    "\n8 - End");
            switch (scanner.nextInt()) {
                case 1:
                    battle.addDroid(Team.Radiance);
                    break;
                case 2:
                    battle.addDroid(Team.Darkness);
                    break;
                case 3:
                    battle.deleteDroid(Team.Radiance);
                    break;
                case 4:
                    battle.deleteDroid(Team.Darkness);
                    break;
                case 5:
                    battle.startBattle();
                    break;
                case 6:
                    battle.printDroidsFromTeam(Team.Radiance);
                    break;
                case 7:
                    battle.printDroidsFromTeam(Team.Darkness);
                    break;
                case 8:
                    return;
            }
        }
    }
}