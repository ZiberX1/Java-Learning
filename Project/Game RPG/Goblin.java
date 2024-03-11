public class Goblin extends Characters {
    Goblin(String name, float hp, float atk) {
        super(name, hp, atk);
        if (name == "Boss") {
            setName("Boss Goblin");
        } else if (name == "Epic") {
            setName("Epic Goblin");
        }
    }
}
