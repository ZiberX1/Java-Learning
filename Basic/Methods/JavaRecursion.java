public class JavaRecursion {
    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result); // Output: 55

        int result2 = sum2(5, 10);
        System.out.println(result2); // Output: 45
    }

    public static int sum(int k) {
        if (k > 0) {
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }
    /*
        10 + sum(9)
        10 + ( 9 + sum(8) )
        10 + ( 9 + ( 8 + sum(7) ) )
        ...
        10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + sum(0)
        10 + 9 + 8 + 7 + 6 + 5 + 4 + 3 + 2 + 1 + 0
    */

    public static int sum2(int start, int end) {
        if (end > start) {
            System.out.println(end);
            return end + sum2(start, end - 1);
        } else {
            return end;
        }
    }
    /*
        10 + sum2(5, 9)
        10 + ( 9 + sum2(5, 8) )
        10 + ( 9 + ( 8 + sum(7) ) )
        ...
        10 + 9 + 8 + 7 + 6 + sum2(5, 5)
        10 + 9 + 8 + 7 + 6 + 5
    */
}
