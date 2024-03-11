import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainUI {
    JFrame f = new JFrame();
    JLabel welcomeLabel = new JLabel("Test");
    
    public MainUI(String username) {
        System.out.println(username);
        welcomeLabel.setText("Welcome to admin page. " + username);
        welcomeLabel.setBounds(100, 150, 300, 25);

        f.add(welcomeLabel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(420, 420);
        f.setTitle("Admin Page");
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
    }
}
