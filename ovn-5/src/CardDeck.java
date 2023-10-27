import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
    ArrayList<PlayCard> cards;
    CardDeck(ArrayList<PlayCard> cards) {
        this.cards = cards;
    }

    ArrayList<PlayCard> shuffle() {
        Collections.shuffle(cards);
        return cards;
    }
}
