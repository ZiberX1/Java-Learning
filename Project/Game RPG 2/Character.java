public class Character {
    private float maxHP;
    private float currentHP;

    private float atk;

    private String name;

    public Character(String name, float maxHP, float atk) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.atk = atk;
    }

    public void attack(Character target) {
        target.currentHP -= this.atk;
        if (target.currentHP <= 0) {
            target.currentHP = 0;
        }
    }

    public void addHP(float hp) {
        this.currentHP += hp;
        if (this.currentHP >= maxHP) {
            this.currentHP = maxHP;
        }
    }

    public float getCurrentHP() {
        return this.currentHP;
    }

    public float getMaxHP() {
        return this.maxHP;
    }

    public float getATK() {
        return this.atk;
    }

    public String getName() {
        return this.name;
    }
}
