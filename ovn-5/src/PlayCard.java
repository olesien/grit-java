import java.util.ArrayList;
import java.util.Arrays;
public class PlayCard {

    int value;
    String color;

    String sign;

    PlayCard(int value, String color, String sign) {
        String[] expectedColors =  {"Red Heart", "Black Spade", "Blue Diamond", "Green Clubs"};
        if (value >= 1 && value <= 15) {
            this.value = value;
        } else {
            this.value = 1;
        }

        if (Arrays.asList(expectedColors).contains(color)) {
            this.color = color;
        } else {
            this.color ="Red Heart";
        }
        this.sign = sign;
    }
}
