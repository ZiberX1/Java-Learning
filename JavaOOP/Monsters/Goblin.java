package JavaOOP.Monsters;

public class Goblin extends Monster {
    private int goblinHP = 15;
    private float goblinATK = 3;

    Goblin() {
        // System.out.println("Creating goblin.");
        setInfo("Goblin", goblinHP, goblinATK);
    }

    Goblin(String type) {
        if (type == "Boss") {
            // System.out.println("Creating boss goblin.");
            setInfo("Boss Goblin", goblinHP * 5, goblinATK * 3);
        } else if (type == "Epic") {
            setInfo("Epic Goblin", goblinHP * 2, goblinATK * 1.5f);
        }
    }
}
