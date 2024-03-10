public class Strings {
    public static void main(String[] args) {
        String txt = "Hello World!";
        System.out.println(txt);

        // String Length:
        System.out.println("The length of txt is: " + txt.length());
        // System.out.printf("The length of \"%s\" is: %d\n", txt, txt.length()); // Output: The length of "Hello World!" is: 12

        System.out.println(txt.toUpperCase()); // Output: HELLO WORLD!
        System.out.println(txt.toLowerCase()); // Output: hello world!

        // Finding a Character in a String
        System.out.println(txt.indexOf("!")); // Output: 11
        System.out.println(txt.indexOf("World")); // Output: 6

        // Concatenation
        String firstName = "Lucas";
        String lastName = "Simpsons";
        System.out.println(firstName + " " + lastName); // Output: Lucas Simpsons
        System.out.println(firstName.concat(lastName)); // Output: LucasSimpsons

        // Numbers and Strings
        int myIntX = 10;
        int myIntY = 20;
        int myIntZ = myIntX + myIntY;
        System.out.println(myIntZ); // Output: 30

        String myTextX = "10";
        String myTextY = "20";
        String myTextZ = myTextX + myTextY;
        System.out.println(myTextZ); // Output: 1020

        System.out.println(myIntX + myTextX); // Output: 1010 -> String

        // Special Characters
        /*
            * \' = '
            * \" = "
            * \\ = \ 
        */
        String text = "My name is \"Lucas\"";
        System.out.println(text); // Output: My name is "Lucas"

        String text2 = "Hello Lucas \t (friend).\nHow are you?";
        System.out.println(text2);
        // Output: Hello Lucas   (friend).
        // Output: How are you?
    }
}
