import java.util.Random;
public class Main {
    private static void randomloop() {
        Random rand = new Random();
        int randomNum = rand.nextInt(10);
        for (int i = 1; i <= randomNum; i++) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {

        int counter = 0;

        long timestamp = System.currentTimeMillis();
        do {
            counter++;
            if (counter % 1000000 == 0) {
                System.out.println(counter);
            }
        } while (counter < 2000000000);
        long timePassed = System.currentTimeMillis() - timestamp;
        System.out.printf("Arbetet tog %d ms \n", timePassed);
        /*System.out.println("for-loop");
        final int MAX_VALUE = 10;
        for (int i = 1; i <= MAX_VALUE; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nwhile-loop");
        int i = 1;
        while (i <= MAX_VALUE) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println("\ndo-while-loop");
        i = 1;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= MAX_VALUE);
        System.out.println("\nRandom loop length");

        randomloop();*/


    }
}