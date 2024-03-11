public class Characters {
    private String name;
    private float hp;
    private float maxHP;
    private float atk;
    private String status;

    Characters(String name, float maxHP, float atk) {
        this.name = name;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.atk = atk;
        this.status = "Alive";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(float amount) {
        hp = amount;
    }

    public String getName() {
        return name;
    }

    public float getHP() {
        return hp;
    }

    public float getMaxHP() {
        return maxHP;
    }

    public float getATK() {
        return atk;
    }

    public void attackTarget(Characters target) {
        if (target != this && target.status != "Died") {
            System.out.printf("[%s] dealt %.01f damge to the [%s].\n", name, atk, target.name);
            target.takeDamage(atk);
        }
    }

    public void takeDamage(float dmg) {
        hp -= dmg;
        // System.out.println(name + " take damage " + dmg);
        if (hp > 0) {
            // System.out.println(name + " hp is " + hp);
        } else {
            status = "Died";
            System.out.println(name + " is died!");
        }
    }

    public float attack() {
        return atk; 
    }
}
