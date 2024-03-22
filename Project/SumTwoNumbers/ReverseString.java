import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
/*      String text = "Hello World!";
        System.out.println(text.length());
        
        String reverse = "";
        for (int i = text.length(); i > 0; i--) {
            reverse = reverse + text.charAt(i-1);
        }
        System.out.println(reverse); 
*/
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text : ");
        String text = input.nextLine();
        System.out.println("Reverse is : " + reverseString(text));
    }

    public static String reverseString(String text) {
        String reverse = "";
        for (int i = text.length(); i > 0; i--) {
            reverse = reverse + text.charAt(i-1);
        }
        return reverse;
    }
}