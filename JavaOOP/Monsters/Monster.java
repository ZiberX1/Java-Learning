package JavaOOP.Monsters;

public class Monster {
    private String name;
    private int hp;
    private int atk;

    Monster() {
        System.out.println("Creating monster.");
    }

    Monster(String name, int hp, int atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }

    public void displayInfo() {
        System.out.printf("Monster: %s | HP: %d | ATK: %d \n", this.name, this.hp, this.atk);
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.hp;
    }

    public int getATK() {
        return this.atk;
    }
}
