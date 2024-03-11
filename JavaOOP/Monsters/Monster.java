public class Monster implements SkillsMonsters {
    private String name;
    private int hp;
    private float atk;
    private String status = "Alive";

    Monster() {
        // System.out.println("Creating monster.");
        this.name = "Monster";
        this.hp = 5;
        this.atk = 1;
    }

    public void displayInfo() {
        if (getHP() == 0) {
            System.out.printf("[%s] is died \n\n", getName());
        } else {
            System.out.printf("[%s] Monster: %s | HP: %d | ATK: %.02f \n\n", status, this.name, this.hp, this.atk);
        }
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

    // Skills
    public void attack(Monster target) {
        if (target != this) {
            System.out.printf("[%s] attacking [%s] with %.02f damage \n", this.getName(), target.getName(), this.getATK());
            target.takeDamage(this.getATK());
        } else {
            System.out.printf("[%s] It cannot attack itself. \n", this.getName());
        }
    }

    public void takeDamage(float damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            this.status = "Died";
        }
        System.out.printf("[%s] takes %.02f damage. HP: %d \n", this.getName(), damage, this.getHP());
        this.displayInfo();
    }
}
