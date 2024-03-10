public class Variables {
    public static void main(String[] args) {
        // type variableName = value;

        // type: String
        String testName = "Mongkorn";
        System.out.println(testName); // Output: Mongkorn

        // type: int
        int testAge = 18;
        System.out.println(testAge); // Output: 18

        // ---------------
        int numberA;
        numberA = 100;
        System.out.println(numberA); // Output: 100

        int numberB = 20;
        numberB = 50;
        System.out.println(numberB); // Output: 50

        String stringA = "Hello.";
        stringA = "Hi!";
        System.out.println(stringA); // Output: Hi!

        // final variables
        final int numberC = 1150;
        // numberC = 1112; // error
        System.out.println(numberC);

        // Others type:
        int testNum = 10;
        float testFloat = 9.99f;
        char testChar = 'X';
        boolean testBool = true;
        String testString = "Test";

        //////////////////////////////////////

        String name = "Teeramat";
        System.out.println(name); // Output: Teeramat

        String firstName = "Teeramat ";
        String lastName = "Chanthod";
        String fullName = firstName + lastName;
        System.out.println(fullName); // Output: Teeramat Chanthod

        // ---------------

        int x = 3;
        int y = 7;
        System.out.println(x + y); // Output: 10

        int a = 12;
        int b = 10;
        int c = 8;
        System.out.println(a + b + c); // Output: 30

        int d = 12, e = 10, f = 8;
        System.out.println(d + e + f); // Output: 30

        int g, h, i;
        g = h = i = 50;
        System.out.println(g + h + i); // Output: 150
    }
}
