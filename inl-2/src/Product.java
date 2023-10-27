public class Product {
    private String name;
    private double price;

    private int amountLeft;

    Product(String name, double price, int amountLeft) {
        this.name = name;
        this.price = price;
        this.amountLeft = amountLeft;
    }

    String getName () {
        return name;
    }

    double getPrice() {
        return price;

    }
    int getAmountLeft( ) {
        return amountLeft;
    }

    boolean buyOne() {
        if (amountLeft > 0) {
            amountLeft--;
            return true;
        }
        return false;
    }
}
