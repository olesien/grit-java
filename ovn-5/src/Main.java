import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {


        //ovn 1
        Pet cat = new Pet("Maja", "cat", "brown");
        System.out.println(cat.info());

        //ovn 2
        BankAccount Account = new BankAccount(100.0);

        Account.addBalance(200.0);

        Account.removeBalance(50.0);
        System.out.println(Account.getBalanace());

        //ovn 3
        PlayCard card = new PlayCard(2, "Black Spade", "Two");
        System.out.println(card.color);

        //ovn 4
        ArrayList<PlayCard> cards = new ArrayList<PlayCard>();
        String[] colors =  {"Red Heart", "Black Spade", "Blue Diamond", "Green Clubs"};
        String[] signs = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Knight", "Queen", "King", "Ace"};

        for (String color : colors) {
            for (int value = 2; value < signs.length + 2; value++) {
                String sign = signs[value - 2];
                cards.add(new PlayCard(value, color, sign));
            }
        }
        for (PlayCard Card : cards) {
            System.out.println(Card.color + " " + Card.sign);
        }

        //ovn 5
        CardDeck carddeck = new CardDeck(cards);
        System.out.println("Randomized:");
        carddeck.shuffle();
        for (PlayCard Card : carddeck.cards) {
            System.out.println(Card.color + " " + Card.sign);
        }

    }
}