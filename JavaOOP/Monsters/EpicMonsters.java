package JavaOOP.Monsters;

public class EpicMonsters extends Monster {
    EpicMonsters() {
        System.out.println("Creating epic monster.");
        setInfo(getName(), getHP() * 2, getATK() * 1.5f);
    }
}
