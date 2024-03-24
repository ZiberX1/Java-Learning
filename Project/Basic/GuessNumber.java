import java.util.Scanner;

/**
 * GuessNumber
 */
public class GuessNumber {

    public static void line(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Random number
        int number = 1 + (int)(100 * Math.random());
        
        // โอกาสในการทาย
        int chances = 5;

        int i, guess;

        line(30);
        System.out.printf("Choose a number\nbetween 1 to 100.\nThere are %d chances to guess\n", chances);
        line(30);

        for (i = 1; i <= chances; i++) {
            System.out.println("Round: " + i);
            // รับค่า input
            System.out.print("Guess a number: ");
            guess = input.nextInt();

            // เช็ค
            if (guess == number) {
                line(30);
                System.out.println("Congratulations, you guessed the number correctly.");
                break;
            }
            else if (guess < number && i != chances) {
                System.out.println("The number is greater than " + guess);
            }
            else if (guess > number && i != chances) {
                System.out.println("The number is less than " + guess);
            }
            line(30);
            
            if (i == chances) {
                System.out.println("You lose");
                System.out.println("The answer is " + number);
                break;
            }
        }
    }
}

// Output:
/*
    ------------------------------
    Choose a number
    between 1 to 100.
    There are 5 chances to guess
    ------------------------------
    Round: 1
    Guess a number: 50
    The number is greater than 50
    ------------------------------
    Round: 2
    Guess a number: 70
    The number is less than 70
    ------------------------------
    Round: 3
    Guess a number: 60
    The number is less than 60
    ------------------------------
    Round: 4
    Guess a number: 58
    The number is greater than 58
    ------------------------------
    Round: 5
    Guess a number: 59
    ------------------------------
    Congratulations, you guessed the number correctly.
*/