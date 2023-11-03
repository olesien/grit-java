import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI {
    int clickCount = 0;
    private JFrame frame;
    private JPanel panel;

    private JLabel label;

    private JButton button;
    GUI() {
        //Skapa ett nytt fönster (syns inte på skärmen)
        frame = new JFrame("Lektion 7");
        //Sätt storlek på det
        frame.setSize(600, 300);
        //Bestäm vad som ska hända när fönstret stängs
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        label = new JLabel("Hejsan svejsan JAVA23!");
        button = new JButton("knapp!");
        JTextField field = new JTextField("Text i fältet");
        JTextArea area = new JTextArea("Text i area");

        button.addActionListener(new ButtonClickListener());

        panel.add(label);
        panel.add(button);
        panel.add(field);
        panel.add(area);



        frame.add(panel);

        //Visa fönstret
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            clickCount++;
            label.setText("Du har klickat " + clickCount + " gånger!");
            System.out.println("Command clicked");

            if (clickCount >= 10) {
                button.setEnabled(false);
            }
        }
    }
}