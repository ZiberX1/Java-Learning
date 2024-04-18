import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    static boolean isRunning;

    static Player player;
    static Goblin monster;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        GameLogic.start();
    }

    // Function
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void pressAnyToContinue() {
        System.out.print("\nEnter any to continue: ");
        sc.next();
        System.out.println();
    }

    public static int readInt(int numsChoice) {
        int input;
        
        do {
            System.out.print("Enter you choice: ");
            try {
                input = Integer.parseInt(sc.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer.");
            }
        } while (input < 1 || input > numsChoice);

        return input;
    }

    public static void printHeading(String text) {
        printSeperator(30);
        System.out.println(text);
        printSeperator(30);
    }

    public static void printSeperator(int nums) {
        for (int i = 0; i < nums; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Start Create player
    public static void start() {
        clearConsole();

        System.out.println("Welcome to the RPG game simple.");
        System.out.println("Made by ZiberX");

        System.out.println("\nStarting -> Create a new player...");
        pressAnyToContinue();

        boolean nameSet = false;
        String playerName;
        do {
            clearConsole();
            System.out.print("\nEnter a player name: ");
            playerName = sc.next();

            System.out.printf("You name is %s, Is that correct?\n", playerName);
            System.out.println("  1) Yes!");
            System.out.println("  2) No, I want to change");
            int choice = readInt(2);
            if (choice == 1) {

                clearConsole();

                nameSet = true;
                System.out.printf("\n\nWelcome %s, have fun!\n\n", playerName);
            }
        } while (!nameSet);

        player = new Player(playerName);

        isRunning = true;

        gameLoop();
    }

    // Game Loop Menu
    public static void gameLoop() {
        while (isRunning) {
            // print menu
            printMainMenu();
            int choice = readInt(3);
            if (choice == 1) {
                // finding monster
                findingMonster();
            } else if (choice == 2) {
                // print character info
                printCharacterInfo();
                pressAnyToContinue();
            } else {
                isRunning = false;
            }
        }
    }

    // Main Menu
    public static void printMainMenu() {
        clearConsole();
        System.out.println("Select you action:");
        printSeperator(20);
        System.out.println("  1) Finding monster");
        System.out.println("  2) Character info");
        System.out.println("  3) Quit");
    }

    // Character Info
    public static void printCharacterInfo() {
        clearConsole();
        printHeading("Character Info".toUpperCase());

        System.out.printf("Name : %s\n", player.getName());
        System.out.printf("HP: %.02f / %.02f\n", player.getCurrentHP(), player.getMaxHP());
        System.out.printf("ATK: %.02f\n", player.getATK());
        System.out.printf("Cash: %d\n", player.getCash());
        System.out.printf("Potions: %d\n", player.getPotion());
    }

    public static void printBattleInfo() {
        System.out.println();
        printSeperator(50);
        System.out.printf("[%s] \t HP: %.02f / %.02f \t ATK: %.02f", player.getName(), player.getCurrentHP(), player.getMaxHP(), player.getATK());
        System.out.println();
        System.out.printf("[%s] \t HP: %.02f / %.02f \t ATK: %.02f", monster.getName(), monster.getCurrentHP(), monster.getMaxHP(), monster.getATK());
        System.out.println();
        printSeperator(50);
    }

    // Shop Menu
    public static void printShopMenu() {
        clearConsole();
        printHeading("Shop Menu");
        System.out.println();
        printSeperator(20);
        System.out.println("[List]");
        System.out.println("Heal potion >> $20");
        printSeperator(20);
        System.out.printf("\nYou have cash: $%d\n", player.getCash());
        printSeperator(20);

        System.out.println("  1) Buy");
        System.out.println("  2) Return to battle");
        int input = readInt(2);
        if (input == 1) {
            clearConsole();

            boolean isBuy = player.buyPotion();
            if (isBuy) {
                System.out.println("Success!");
            } else {
                System.out.println("You not have enough cash");
            }
            pressAnyToContinue();
        }
    }

    // Battle Menu
    public static void battleMenu() {
        while (true) {
            clearConsole();
            printHeading("Battle Menu");
    
            // Battle info player and monster
            printBattleInfo();
    
            System.out.println("  1) Attack");
            System.out.println(String.format("  2) Drink potion (You have %d)", player.getPotion()));
            System.out.println("  3) Open shop");
            System.out.println("  4) Run away!");
            int input = readInt(4);
            if (input == 1) {
                // battle
                
                battle_atkPlayer();
                // check is died
                if (monster.getCurrentHP() == 0) {
                    System.out.printf("Nice You Kill Monster.. recive ($%d)\n", monster.dropCoin());
                    player.addCash(monster.dropCoin());
                    pressAnyToContinue();
                    break;
                }

                battle_atkMonster();
                // check is died
                if (player.getCurrentHP() == 0) {
                    System.out.println("You died!");
                    pressAnyToContinue();
                    isRunning = false;
                    break;
                }
            } else if (input == 2) {
                // drink potion
                clearConsole();
                boolean drinking = player.drinkPotion();
                if (drinking) {
                    System.out.println("Drinking heal potion...");
                } else {
                    System.out.println("You dont havew enough potions");
                }
                pressAnyToContinue();
            } else if (input == 3) {
                // menu shop
                printShopMenu();
            } else if (input == 4) {
                // run away
                boolean luck = getLuck(); // if you luck more than 60 == you are lucky
                if (luck) {
                    clearConsole();
                    System.out.println("\n\nYou lucky ... run away");
                    printSeperator(20);
                    pressAnyToContinue();
                    break;
                } else {
                    clearConsole();
                    System.out.println("\n\nYou are bad luck, go fight monster");
                    printSeperator(20);
                    pressAnyToContinue();

                    battle_atkMonster();
                }
            }
        }
        
    }

    // Game
    public static void findingMonster() {
        // Random 1-3
        int gradeMonster = random.nextInt(3) + 1;

        // creating monster
        if (gradeMonster == 1) {
            monster = new Goblin("Goblin", 20.0f, 3.0f);
        } else if (gradeMonster == 2) {
            monster = new Goblin("Epic Goblin", 60.0f, 6.0f);
        } else if (gradeMonster == 3) {
            monster = new Goblin("Boss Goblin", 120.0f, 10.0f);
        }
        
        clearConsole();
        printHeading(String.format("Found monster >> %s", monster.getName()));
        pressAnyToContinue();
        
        // battle menu
        battleMenu();
    }

    // Run away
    public static boolean getLuck() {
        int luck = random.nextInt(100) + 1;

        if (luck >= 60) {
            return true;
        }

        return false;
    } 

    public static void battle_atkPlayer() {
        clearConsole();

        printSeperator(40);
        System.out.printf("[%s] attacking to [%s] with deal (%.02f)\n", player.getName(), monster.getName(), player.getATK());
        player.attack(monster);
        printSeperator(40);

        pressAnyToContinue();
        clearConsole();
    }
    
    public static void battle_atkMonster() {
        clearConsole();
        
        printSeperator(40);
        System.out.printf("[%s] attacking to [%s] with deal (%.02f)\n", monster.getName(), player.getName(), monster.getATK());
        monster.attack(player);
        printSeperator(40);
        
        pressAnyToContinue();
        clearConsole();
    }
}
