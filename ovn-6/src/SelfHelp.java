import java.util.Random;

public class SelfHelp extends Book {
    private String message;
    private String[] questions;
    SelfHelp(String title, String author, int pages, String message, String[] questions) {
        super(title, author, pages);
        this.message = message;
        this.questions = questions;
    }

    void DoSelfHelp() {
        Random rand = new Random();
        int questionIndex = rand.nextInt(3);

        System.out.println(questions[questionIndex]);
    }

    public String getMessage() {
        return message;
    }
}
