public class Main {
    public static void main(String[] args) {
        int myInt = 1;
        float myFloat = 2.0f;
        double myDouble = 3.0;
        char myChar = 'S';
        boolean myBool = false;

        myFloat = myInt;
        myDouble = myFloat;
        System.out.printf("Widening cast: %.10f %.10f %d\n", myDouble, myFloat, myInt);
        myDouble = 3.1423290308238;
        myFloat = (float) myDouble;
        myInt = (int) myFloat;
        System.out.printf("Narrowing cast: %.10f %.10f %d\n", myDouble, myFloat, myInt);
    }
}