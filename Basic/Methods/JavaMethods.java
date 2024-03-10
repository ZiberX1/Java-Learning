public class JavaMethods {
    static void testMethod() {
        System.out.println("Execute testMethod()");
    }

    // Parameters and Arguments
    static void testMethodWithParam(String txt) {
        System.out.println("You write " + txt);
    }

    // Multiple Parameters
    static void testMethodMultiParam(String name, int age) {
        System.out.println(name + " is " + age);
    }

    // Return Values
    static int addMethod(int x) {
        return 5 + x;
    }

    static int addnums(int a, int b) {
        return a + b;
    }

    // A Method with If..Else
    static void checkAge(int age) {
        if (age < 18) {
            System.out.println("You are not old enough!");
        } else {
            System.out.println("You are old enough!");
        }
    }

    // Method Overloading
    static int plusMethod(int x, int y) {
        return x + y;
    }

    static double plusMethod(double x, double y) {
        return x + y;
    }

    public static void main(String[] args) {
        testMethod();
        testMethod();
        testMethod();
        // Output:
        // Execute testMethod()
        // Execute testMethod()
        // Execute testMethod()

        testMethodWithParam("Hello my friend.");
        testMethodWithParam("Hi John.");
        // Output:
        // You write Hello my friend.
        // You write Hi John.

        testMethodMultiParam("John", 19);
        testMethodMultiParam("Lucas", 20);
        // Output:
        // John is 19
        // Lucas is 20

        System.out.println(addMethod(10)); // Output: 15
        System.out.println(addnums(2, 3)); // Output: 5

        int z = addnums(9, 10);
        System.out.println(z); // Output: 19

        checkAge(20); // Output: You are old enough!
        checkAge(15); // Output: You are not old enough!

        // Method Overloading
        int myNum1 = plusMethod(10, 5);
        double myNum2 = plusMethod(3.14, 7.7);
        System.out.println(myNum1); // Output: 15
        System.out.println(myNum2); // Output: 10.84
    }
}