public class JavaLoop {
    public static void main(String[] args) {
        // While Loop
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
        // Output: 0 to 9

        // Do/While Loop
        int x = 0;
        do {
            System.out.println(x);
            x++;
        } while (x < 5);
        // Output: 0 to 4

        // For Loop
        for (int j = 0; j < 3; j++) {
            System.out.println(j);
        }
        // Output: 0 to 2

        for (int j = 0; j <= 10; j = j + 2) {
            System.out.println(j);
        }
        // Output: 2 4 6 8 10

        // Nested Loops
        // Outer loop
        for (int j = 1; j <= 2; j++) {
            System.out.println("Outer: " + j); // Executes 2 times

            // Inner loop
            for (int j2 = 1; j2 <= 3; j2++) {
                System.out.println("Inner: " + j2); // Executes 6 times (2 * 3)
            }
        }

        // For Each Loop
        String[] cars = {"BMW", "Honda", "Ford"};
        for (String c : cars) {
            System.out.println(c);
        }
    }
}
