package org.linus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "Linus";
        Integer luckynum = 11;
        System.out.println("Hello " + name);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Integer num = Integer.parseInt(input);

        if (num.equals(luckynum)) {
            System.out.println("You got lucky!");
        } else {
            System.out.println("No luck for you");
        }
    }
}