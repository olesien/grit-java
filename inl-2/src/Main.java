import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Fake Spider", 100.10, 1));
        products.add(new Product("Eye", 70.10, 33));
        products.add(new Product("Scary Doll", 1000.10, 2));

        boolean StillShopping = true;
        while (StillShopping) {
            for (int i = 1; i <= products.size() + 1; i++) {

                if (i == products.size() + 1) {
                    System.out.println(i + ". Quit");
                } else {
                    Product product = products.get(i - 1);
                    System.out.printf("%d. %s %,.2f SEK, %d left%n", i, product.getName(), product.getPrice(), product.getAmountLeft());
                }
            }
            System.out.print("Choose your option: ");
            int answer = scanner.nextInt();
            if (answer > 0 && answer <= products.size()) {
                //Check if we can buy one
                Product product = products.get(answer - 1);
                boolean hasBought = product.buyOne();
                if (!hasBought) {
                    System.out.println("Sorry but that item is out of stock!");
                } else {
                    //Adjust the basket
                    customer.addTobasket(product.getPrice());
                }
            } else if (answer == products.size() + 1) {
                //End it
                StillShopping = false;
            } else {
                //Invalid response
                System.out.println("Invalid response.");
            }
        }

        System.out.printf("You purchased a total of %d items. The total cost was %,.2f SEK", customer.getAmount(), customer.getTotalCost());

    }
}