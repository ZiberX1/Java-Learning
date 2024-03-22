import java.util.Scanner;

public class Sums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = input.nextInt();
        
        System.out.print("Enter second number: ");
        int b = input.nextInt();

        input.close();

        System.out.println("Sum = " + sum(a, b));
        // Output:
        /*
            Enter first number: 100
            Enter second number: 20
            Sum = 120
        */
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}