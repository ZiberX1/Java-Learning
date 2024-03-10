public class JavaMath {
    public static void main(String[] args) {
        // Math.max | Math.min
        System.out.println(Math.max(10, 20)); // Output: 20
        System.out.println(Math.min(10, 20)); // Output: 10

        // Math.abs(x)
        System.out.println(Math.abs(-2.2)); // Output: 2.2

        // Random Numbers
        System.out.println(Math.random()); // Output: random number between 0.0 (inclusive), and 1.0 (exclusive)
        int randomNum = (int)(Math.random() * 101); // 0 to 100
        System.out.println(randomNum); // Output: random number between 0 to 100
    }
}
