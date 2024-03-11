import java.util.Scanner;

public class GameLogic {
    static boolean isRunning;
    static Player player;

    static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch(Exception e) {
                input = -1;
                System.out.println("Please enter an integer.");
            }
        } while (input < 1 || input > userChoices);

        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void printSeperator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeperator(30);
        System.out.println(title);
        printSeperator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;

        // Title
        clearConsole();
        printSeperator(40);
        printSeperator(30);
        System.out.println("PROJECT GAME RPG");
        System.out.println("This is simple game.");
        printSeperator(30);
        printSeperator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();

            clearConsole();
            printHeading("You name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("->", 2);
            if (input == 1) {
                nameSet = true;

                clearConsole();
                printHeading("Welcome " + name + " to the game.");
                anythingToContinue();
                clearConsole();
            }
        } while (!nameSet);

        // create player
        player = new Player(name);

        isRunning = true;

        gameLoop();
    }

    public static void battleInfo(Goblin enemy) {
        printSeperator(50);
        System.out.println(String.format("[%s] HP: %.01f / %.01f \t ATK: %.01f", player.getName(), player.getHP(), player.getHP(), player.getATK()));
        System.out.println(String.format("[%s] HP: %.01f / %.01f \t ATK: %.01f", enemy.getName(), enemy.getHP(), enemy.getHP(), enemy.getATK()));
        printSeperator(50);
    }

    public static void createGoblin() {
        clearConsole();
        printHeading("You found enemies -> Goblin");
        anythingToContinue();
        battle(new Goblin("Goblin", 20, 3));
    }

    public static void battle(Goblin enemy) {
        while (true) {
            clearConsole();
            battleInfo(enemy);
            System.out.println("Choose an action:");
            printSeperator(20);
            System.out.println("(1) Fight");
            System.out.println("(2) Use Potion");
            System.out.println("(3) Run Away");
            int input = readInt("->", 3);
            if (input == 1) {
                // Fight
                float dmg = player.attack();
                float dmgTook = enemy.attack();

                player.setHP(player.getHP() - dmgTook);
                enemy.setHP(enemy.getHP() - dmg);

                clearConsole();
                printHeading("BATTLE");
                System.out.printf("You dealt %d damage to the [%s].\n", (int) dmg, enemy.getName());
                printSeperator(15);
                System.out.printf("The [%s] dealt %d damage to you.\n", enemy.getName(), (int) dmgTook);
                printSeperator(15);
                anythingToContinue();

                if (player.getHP() <= 0.0) {
                    playerDied();
                    break;
                } else if (enemy.getHP() <= 0) {
                    clearConsole();
                    printHeading(String.format("You defeated the %s !", enemy.getName()));
                    anythingToContinue();
                    break;
                }
            } else if (input == 2) {
                // use potion
                clearConsole();
                if (player.pots > 0 && player.getHP() < player.getMaxHP()) {
                    printHeading(String.format("Do you want to drink a potion? ( %d left )", player.pots));
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("->", 2);
                    if (input == 1) {
                        player.pots -= 1;
                        player.setHP(player.getMaxHP());
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to " + (int) player.getMaxHP());
                        anythingToContinue();
                    }
                } else {
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }
            } else {
                // run away
                clearConsole();
                if (Math.random()*10 + 1 <= 3.5) {
                    printHeading("You ran away from the " + enemy.getName() + " !");
                    anythingToContinue();
                    break;
                } else {
                    printHeading("You did't manage to escape.");
                    player.setHP(player.getHP() - enemy.attack());
                    System.out.println("In you hurry you took " + (int) enemy.attack() + " damage!");
                    anythingToContinue();

                    if (player.getHP() <= 0.0) {
                        playerDied();
                        break;
                    }
                }
            }
        }
    }

    public static void continueJourney() {
        createGoblin();
    }

    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.printf("[%s] HP: %.01f/%d\n", player.getName(), player.getHP(), (int) player.getMaxHP());
        printSeperator(20);
        System.out.printf("Stats | ATK: %.01f\n", player.getATK());
        System.out.printf("Bag | Potions: %d\n", player.pots);
        printSeperator(20);

        anythingToContinue();
    }

    public static void printMenu() {
        clearConsole();
        printHeading("MENU");
        System.out.println("Choose an action:");
        printSeperator(20);
        System.out.println("(1) Finding monsters");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
        System.out.println("Thank you for playing my game. I hope you enjoyed it :)");
        System.out.println(String.format("Good luck %s", player.getName()));
        System.out.println();
        isRunning = false;
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }

}
