public class JavaArrays {
    public static void main(String[] args) {
        String[] cars = {"BMW", "Ford", "Honda"};
        System.out.println(cars[0]); // Output: BMW
        System.out.println(cars[1]); // Output: Ford
        System.out.println(cars[2]); // Output: Honda

        // Change an Array Element
        cars[0] = "Mazda";
        System.out.println(cars[0]); // Output: Mazda

        // Array Length
        System.out.println(cars.length); // Output: 3

        // Arrays Loop
        String[] vehicles = {"BMX", "Benz", "Porsche", "Honda"};

        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i]);
        }

        for (String veh : vehicles) {
            System.out.println(veh);
        }

        // Multi-Dimensional Arrays
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        System.out.println(myNumbers[1][0]); // Output: 5
        System.out.println(myNumbers[1][2]); // Output: 7

        System.out.println(myNumbers[0][0]); // Output: 1
        System.out.println(myNumbers[0][1]); // Output: 2

        // Change Element Values
        myNumbers[0][0] = 0;
        System.out.println(myNumbers[0][0]); // Output: 0

        // Loop Through a Multi-Dimensional Array
        for (int i = 0; i < myNumbers.length; i++) {
            for (int j = 0; j < myNumbers[i].length; j++) {
                System.out.println(myNumbers[i][j]);
            }
        }
        // Output: 0 2 3 4 5 6 7
    }
}
