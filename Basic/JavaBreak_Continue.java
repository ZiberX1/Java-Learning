public class JavaBreak_Continue {
    public static void main(String[] args) {
        // Java Break
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                break;
            }
            System.out.println(i);
        }
        // Output: 0 to 3

        // Java Continue
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
        // Output: 0 1 2 3 5 6 7 8 9 (no have 4)
    }
}
