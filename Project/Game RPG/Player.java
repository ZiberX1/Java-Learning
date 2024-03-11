public class Player extends Characters {
    private String[] potions = {"Heal"};
    public int pots;

    Player(String name) {
        super(name, 30, 5);
        this.pots = 1;
    }

    public void drinkPotion(String type) {
        if (type == potions[0]) {
            float maxHP = getMaxHP();
            float tempHP = getHP();
            float hp = tempHP + 20;
            if (hp >= maxHP) {
                hp = maxHP;
            }
            setHP(hp);
            System.out.println(getName() + " drinking heal potion.");
            System.out.println("Now HP is " + getHP() + " from " + tempHP);
        }
    }

}
