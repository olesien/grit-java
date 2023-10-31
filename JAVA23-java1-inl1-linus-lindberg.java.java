package org.linus;
import java.util.Scanner;
import java.util.Random;

public class Main {
    //This function takes in two numbers and compares them
    static boolean evalNum(int num, int luckyNum) {
        //Check if the number is bigger than, less than or equal to and give feedback.
        if (num > luckyNum) {
            System.out.println("Your guess was too high!!");
        } else if (num < luckyNum) {
            System.out.println("Your guess was too low!!");
        } else {
            System.out.println("You got it right!");
        }

        //Return true or false based on whether they are equal.
        return num == luckyNum;
    }

    //Ask the user to input a number and then use eval number to compare it and return that
    static boolean guess(Scanner scanner, int luckyNum) {
        System.out.print("Please enter a number: ");
        String input = scanner.next();
        int num = Integer.parseInt(input);
        return evalNum(num, luckyNum);
    }
    public static void main(String[] args) {
        //Variable declarations
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int luckyNum = rand.nextInt(101) ;
        int guessCount = 0;
        int bestGuessCount = 0;
        System.out.println("Guess a number between 0 and 100!");
        while (true) {
           boolean isRight = guess(scanner, luckyNum);
           guessCount++;
           if (isRight) {
               //Reset the code
               String endString = " guesses.";
               if (guessCount == 1) {
                   endString = " guess.";
               }
               System.out.println("Great job! New number has now been randomized. It took you " + guessCount + endString);
               if (guessCount < bestGuessCount) {
                   if (bestGuessCount != 0) {
                       System.out.println("You have beat your previous record that was " + bestGuessCount);
                   }
                   bestGuessCount = guessCount;

               } else if (bestGuessCount != 0) {
                   System.out.println("Your record is still " + bestGuessCount);
               }
               guessCount = 0;
               luckyNum = rand.nextInt(101);
           }
        }
    }
}
