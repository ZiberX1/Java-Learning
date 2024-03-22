import javax.swing.JFrame;
import javax.swing.JLabel;

public class Newpage {
    // หน้า welcome
    // JFrame
    JFrame f = new JFrame();
    JLabel textJLabel = new JLabel();
    
    Newpage(String text) {
        textJLabel.setText("Welcome " + text);
        textJLabel.setBounds(120, 75, 200, 30);
        f.add(textJLabel);

        // UI
        f.setTitle("Page");
        f.setSize(350, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);
    }
}
