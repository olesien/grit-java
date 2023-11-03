import javax.swing.*;
public class GUI {

    GUI() {
        //Skapa ett nytt fönster (syns inte på skärmen)
        JFrame frame = new JFrame("Lektion 7");
        //Sätt storlek på det
        frame.setSize(600, 300);
        //Bestäm vad som ska hända när fönstret stängs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Hejsan svejsan JAVA23!");
        JButton button = new JButton("knapp!");
        JTextField field = new JTextField("Text i fältet");
        JTextArea area = new JTextArea("Text i area");

        panel.add(label);
        panel.add(button);
        panel.add(field);
        panel.add(area);



        frame.add(panel);

        //Visa fönstret
        frame.setVisible(true);
    }
}
