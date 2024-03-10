public class Operators {
    public static void main(String[] args) {
        // Arithmetic operators
        // Addition:
        int myInt1 = 10 + 20;
        System.out.println(myInt1); // Output: 30

        // Subtraction:
        int myInt2 = 20 - 10;
        System.out.println(myInt2); // Output: 10

        // Multiplication:
        int myInt3 = 2 * 3;
        System.out.println(myInt3); // Output: 6

        // Division:
        int myInt4 = 100 / 2;
        System.out.println(myInt4); // Output: 50

        // Modulus:
        int myInt5 = 24 % 7;
        int myInt6 = 24 % 8;
        System.out.println(myInt5); // Output: 3
        System.out.println(myInt6); // Output: 0

        // Increment:
        int myInt7 = 10;
        myInt7++;
        System.out.println(myInt7); // Output: 11
        ++myInt7;
        System.out.println(myInt7); // Output: 12

        // Decrement:
        int myInt8 = 20;
        myInt8--; // --myInt8 | same as increment ++
        System.out.println(myInt8); // Output: 19

        // Assignment operators
        int x1 = 5; // =
        x1 += 5; // += | x1 = 5 + 5
        System.out.println(x1); // Output: 10
        x1 -= 5; // -+ | x1 = 10 - 5
        System.out.println(x1); // Output: 5
        x1 *= 10; // *= | x1 = 5 * 10
        System.out.println(x1); // Output: 50
        x1 /= 5; // /= | x1 = 50 / 5
        System.out.println(x1); // Output: 10
        x1 %= 3; // %= | x1 = 10 % 3
        System.out.println(x1); // Output: 1

        boolean myBool1 = true;
        boolean myBool2 = false;
        myBool1 &= myBool2; // AND &= | myBool1 = myBool2 >> (myBool1 = myBool1 & myBool2)
        System.out.println(myBool1); // Output: false
        myBool1 |= true; // OR |= | (myBool1 = myBool1 | true)
        System.out.println(myBool1); // Output: true
        
        // Comparison operators
        int x2 = 10;
        int x3 = 20;
        // Equal to x == y
        System.out.println(x2 == x3); // Output: false
        // Not equal x != y
        System.out.println(x2 != x3); // Output: true
        // Greater than x > y
        System.out.println(x2 > x3); // Output: false
        // Less than x < y
        System.out.println(x2 < x3); // Output: true

        int x4 = 12, x5 = 12;
        System.out.println(x4 >= x5); // Output: true
        System.out.println(x4 <= x5); // Output: true

        // Logical operators
        int a = 10, b = 20;
        // Logical and: Returns true if both statements are true
        System.out.println((a == 10) && (b == 20)); // Output: true
        System.out.println((a != 15) && (b < 5)); // Output: false

        // Logical or: Returns true if one of the statements is true
        System.out.println((a == 10) || (b == 100)); // Output: true
        System.out.println((a != 10) || (b != 20)); // Output: false

        // Logical not: Reverse the result, returns false if the result is true
        System.out.println(!(a > 5 && b < 25)); // Output: false
        System.out.println((a > 5 && b < 25)); // Output: true

    }
}
