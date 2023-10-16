import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final double PI = 3.14;

        String name = "Linus";
        Integer luckynum = 11;
        System.out.println("What is your radius?");
        Scanner scanner = new Scanner(System.in);

        double radius = scanner.nextDouble();

        double circumference = 2 * PI * radius;

        System.out.println("The circumference is " + circumference);


    }
}