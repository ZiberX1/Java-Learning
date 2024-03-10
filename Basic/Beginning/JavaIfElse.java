public class JavaIfElse {
    public static void main(String[] args) {
        // The if Statement
        if (10 > 5) {
            System.out.println("10 is greater than 5"); // Output: 10 is greater than 5
        }
        
        int x = 25, y = 20;
        if (x > y) {
            System.out.println("x is greater than y"); // Output: x is greater than y
        }

        // The else Statement
        int time = 20;

        if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        // Output: Good evening.
        
        // The else if Statement
        if (time < 10) {
            System.out.println("Good morning.");
        } else if (time < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        // Output: Good evening.

        // Short Hand If...Else
        // variable = (condition) ? expressionTrue : expresstionFalse;
        int clock = 20;

        if (clock < 18) {
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
        // Output: Good evening.
        
        String result = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(result);
        // Output: Good evening.
    }
}
