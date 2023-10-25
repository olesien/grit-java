import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void part1() {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[7];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Enter number: ");
            int input = scanner.nextInt();
            nums[i] = input;
        }
        float sum = 0;
        for (int num : nums) {
            sum += num;
        }

        float avg = sum / nums.length;
        System.out.println("THE AVERAGE IS: " + avg);
    }
    public static void part2() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> nums = new ArrayList<Double>();
        for (int i = 0; i < 7; i++) {
            System.out.println("Enter float number: ");
            Double input = scanner.nextDouble();
            if (input >= 0 && input <= 100) {
                nums.add(input);
            } else {
                System.out.println("The number is either too small or too large!");
                i--;
            }
        }
        Collections.sort(nums);
        System.out.println("The lowest number was " + nums.getFirst() + " and will thus be removed");
        nums.remove(0);
        System.out.println("The highest number was " + nums.getLast() + " and will thus be removed");
        nums.remove(nums.size() - 1);
        System.out.println(nums);

        double sum = nums.stream().reduce(0.0, Double::sum);

        double avg = sum / nums.size();
        System.out.println("THE AVERAGE IS: " + avg);
    }

    public static void part3() {
        Scanner scanner = new Scanner(System.in);
       HashMap<String, Double> currencies = new HashMap<String, Double>();
       currencies.put("USD", 0.090);
       currencies.put("DKK", 0.63);

       double SEK = 10000; //10K kr
        System.out.println("Enter currency to convert SEK to");
        String pickedCurrency = scanner.nextLine();

        if (currencies.containsKey(pickedCurrency)) {
            Double currency = currencies.get(pickedCurrency);
            Double total = currency * SEK;
            System.out.printf("Your currency in %s is %f", pickedCurrency, total );
        } else {
            System.out.println("This currency could not be found :(");
        }



    }
    public static void main(String[] args) {

        System.out.println("Running ovn 4");
        //part1();
        //part2();
        part3();
    }
}