package JavaOOP.Monsters;

public class Main {
    public static void main(String[] args) {
        Monster mon1 = new Monster();
        mon1.displayInfo();

        Monster mon2 = new Monster();
        mon2.displayInfo();

        Goblin goblin1 = new Goblin();
        goblin1.displayInfo();

        Goblin goblinBoss1 = new Goblin("Boss");
        goblinBoss1.displayInfo();

        Goblin goblinEpic1 = new Goblin("Epic");
        goblinEpic1.displayInfo();

        Goblin testGoblin = new Goblin("Haha");
        testGoblin.displayInfo();
        

    }
}
