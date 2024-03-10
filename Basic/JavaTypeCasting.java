public class JavaTypeCasting {
    public static void main(String[] args) {
        /* 
         * Widening Casting (automatically) - smaller type to larger type size
            byte > short > char > int > long > float > double

         * Narrowing Caster (manually) - larger type to smaller type size
            double > float > long > int > char > short > byte
        */

        // Widening Casting
        int myInt1 = 24;
        double myDouble1 = myInt1; // Automatic casting: int to double.
        System.out.println(myInt1); // Output: 24
        System.out.println(myDouble1); // Output: 24.0

        // Narrowing Casting
        double myDouble2 = 3.14d;
        int myInt2 = (int) myDouble2; // Manual casting: double to int.
        System.out.println(myDouble2); // Output: 3.14
        System.out.println(myInt2); // Output: 3
    }
}
