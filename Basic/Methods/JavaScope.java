public class JavaScope {
    public static void main(String[] args) {

        int y = 20;

        // Code here can use y
        // Code here CANNOT use x
        
        {
            // Code here can use y

            int x = 100;
            // Code here can use x

            System.out.println(x);
            // Output: 100

            System.out.println(y);
            // Output: 20
        }

        // System.out.println(x); --> error CANNOT use x
        System.out.println(y); // Output: 20
    }
}
