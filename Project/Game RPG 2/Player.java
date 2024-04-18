public class Player extends Character {
    private int cash = 0;
    private int potions = 1;

    public Player(String name) {
        super(name, 100.0f, 10.0f);
    }

    public boolean drinkPotion() {
        if (potions > 0) {
            potions -= 1;
            
            this.addHP(50.0f);
            return true;
        }

        return false;
    }

    public int getPotion() {
        return this.potions;
    }

    public boolean buyPotion() {
        int price = 20;

        if (this.cash > price) {

            this.cash -= price;
            this.potions += 1;

            return true;
        }

        return false;
    }

    public int getCash() {
        return this.cash;
    }

    public void addCash(int coins) {
        this.cash += coins;
    }

}
