package JavaOOP.Monsters;

public class Monster {
    private String name;
    private int hp;
    private float atk;

    Monster() {
        // System.out.println("Creating monster.");
        this.name = "Monster";
        this.hp = 5;
        this.atk = 1;
    }

    public void displayInfo() {
        System.out.printf("Monster: %s | HP: %d | ATK: %.02f \n", this.name, this.hp, this.atk);
    }

    public String getName() {
        return this.name;
    }

    public int getHP() {
        return this.hp;
    }

    public float getATK() {
        return this.atk;
    }

    protected void setInfo(String name, int hp, float atk) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
    }
}
