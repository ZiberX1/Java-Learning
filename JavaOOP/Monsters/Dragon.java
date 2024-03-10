package JavaOOP.Monsters;

public class Dragon extends Monster {
    private int dragonHP = 100;
    private float dragonATK = 20;

    Dragon() {
        // System.out.println("Creating dragon.");
        setInfo("Dragon", dragonHP, dragonATK);
    }
}
