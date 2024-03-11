public class Main {
    public static void main(String[] args) {
        Monster mon1 = new Monster();
        mon1.displayInfo(); // Output: [Alive] Monster: Monster | HP: 5 | ATK: 1.00

        Goblin goblin1 = new Goblin();
        goblin1.displayInfo(); // Output: [Alive] Monster: Goblin | HP: 15 | ATK: 3.00

        Goblin goblinBoss1 = new Goblin("Boss");
        goblinBoss1.displayInfo(); // Output: [Alive] Monster: Boss Goblin | HP: 75 | ATK: 9.00

        Goblin goblinEpic1 = new Goblin("Epic");
        goblinEpic1.displayInfo(); // Output: [Alive] Monster: Epic Goblin | HP: 30 | ATK: 4.50
        
        Dragon dragon1 = new Dragon();
        dragon1.displayInfo(); // Output: [Alive] Monster: Dragon | HP: 100 | ATK: 20.00

        // Attacking
        dragon1.attack(mon1);
        // Output:
        // [Dragon] attacking [Monster] with 20.00 damage 
        // [Monster] takes 20.00 damage. HP: 0
        // [Monster] is died

        goblin1.attack(dragon1);
        // Output:
        // [Goblin] attacking [Dragon] with 3.00 damage
        // [Dragon] takes 3.00 damage. HP: 97
        // [Alive] Monster: Dragon | HP: 97 | ATK: 20.00

        goblinEpic1.attack(dragon1);
        // Output:
        // [Epic Goblin] attacking [Dragon] with 4.50 damage
        // [Dragon] takes 4.50 damage. HP: 92
        // [Alive] Monster: Dragon | HP: 92 | ATK: 20.00

        goblinBoss1.attack(dragon1);
        // Output:
        // [Boss Goblin] attacking [Dragon] with 9.00 damage
        // [Dragon] takes 9.00 damage. HP: 83 
        // [Alive] Monster: Dragon | HP: 83 | ATK: 20.00

        dragon1.attack(dragon1); // Output: [Dragon] It cannot attack itself.

        dragon1.attack(goblin1);
        // Output:
        // [Dragon] attacking [Goblin] with 20.00 damage
        // [Goblin] takes 20.00 damage. HP: 0
        // [Goblin] is died

        dragon1.attack(goblinBoss1);
        // Output:
        // [Dragon] attacking [Boss Goblin] with 20.00 damage
        // [Boss Goblin] takes 20.00 damage. HP: 55
        // [Alive] Monster: Boss Goblin | HP: 55 | ATK: 9.00
    }
}
