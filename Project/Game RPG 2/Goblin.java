public class Goblin extends Character {
    private int coin;

    public Goblin(String name, float maxHP, float atk) {
        super(name, maxHP, atk);

        if (name == "Goblin") {
            coin = 10;
        } else if (name == "Epic Goblin") {
            coin = 30;
        } else if (name == "Boss Goblin") {
            coin = 50;
        }
    }

    public int dropCoin() {
        return this.coin;
    }
}
