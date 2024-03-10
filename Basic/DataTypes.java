public class DataTypes {
    public static void main(String[] args) {
        /*
         * Data types:

         * Primitive data type: - includes | byte, short, int, long, float, double, boolean, char

         * Non-Primitive data types: - such as | String, Arrays and Classes

        */

        int myNum = 4;
        float myFloatNum = 3.14f;
        char myLetter = 'A';
        boolean myBool = false;
        String myText = "Hello World!";

        // Integer Types:
        // Byte | -128 to 127
        byte myByte = 100;
        System.out.println(myByte); // Output: 100

        // Short | -32768 to 32767
        short myShort = 12345;
        System.out.println(myShort); // Output: 12345

        // Int | -2147483648 to 2147483647
        int myInt = 1000000;
        System.out.println(myInt); // Output: 1000000

        // Long | -9223372036854775808 to 9223372036854775807 (จะใช้เมื่อค่ามีมากเกินกว่าที่ int จะเก็บได้ และเติม L ลงท้าย)
        long myLong = 20000000000L;
        System.out.println(myLong); // Output: 20000000000

        // Floating Point Types:
        // Float: end the value with "f"
        float myFloat = 3.14f;
        System.out.println(myFloat);  // Output: 3.14

        // Double: end the value with "d"
        double myDouble = 20.999d;
        System.out.println(myDouble); // Output: 20.999

        // Scientific Numbers
        // "e" to indicate the power of 10:
        float f1 = 20e3f; // 20*10^3
        double d1 = 12E4d; // 12*10^4
        System.out.println(f1); // Output: 20000.0
        System.out.println(d1); // Output: 120000.0

        // Boolean Types:
        // Yes or No | On or Off | True or False
        boolean isGood = true;
        boolean isDirty = false;
        System.out.println(isGood); // Output: true
        System.out.println(isDirty); // Output: false

        // Characters:
        char myGrade = 'F';
        System.out.println(myGrade); // Output: F

        // ASCII (https://www.w3schools.com/charsets/ref_html_ascii.asp)
        char myChar1 = 65, myChar2 = 66, myChar3 = 67;
        System.out.println(myChar1); // Output: A
        System.out.println(myChar2); // Output: B
        System.out.println(myChar3); // Output: C

        // Strings
        String myHello = "What are you doing?";
        System.out.println(myHello); // Output: What are you doing?

        // Difference between `primitive` and `non-primitive`:
        /*
            -  Primitive types ถูกกำหนดค่าไว้แล้วโดย Java | Non-primitve types ถูกสร้างโดยโปรแกรมเมอร์ และยังไม่ถูกกำหนดโดย Java (ยกเว้น String)
            - Non-primitive types สามารถใช้ to call methods to perform certain operations แต่ primitive types ไม่สามารถทำได้
            - Primitive types มี value เสมอ แต่ Non-primitive types สามารถมี value = null ได้
            - Primitive types จะเริ่มต้นด้วย lowercase letter แต่ Non-primitive types จะเริ่มต้นด้วย uppercase letter
        */
    }
}
