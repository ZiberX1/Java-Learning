import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Login.LoginSImple.MainUI;

public class LoginUI implements ActionListener {
    private HashMap<String, String> usersData = new HashMap<String, String>();

    // UI
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JTextField usernameTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel statusLabel = new JLabel("Status:");
    
    LoginUI(HashMap<String, String> usersData) {
        this.usersData = usersData;
        // System.out.println(this.usersData);

        usernameLabel.setBounds(20, 20, 70, 20);
        usernameTextField.setBounds(90, 20, 170, 20);
        
        passwordLabel.setBounds(20, 50, 70, 20);
        passwordField.setBounds(90, 50, 170, 20);

        loginButton.setBounds(92, 90, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        statusLabel.setBounds(10, 120, 200, 20);
        statusLabel.setFont(new Font(null, Font.PLAIN, 11));

        frame.add(loginButton);
        frame.add(usernameLabel);
        frame.add(usernameTextField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(statusLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Login");
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameTextField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (usersData.containsKey(username)) {
                if (usersData.get(username).equals(password)) {
                    // System.out.println("Login successful.");
                    statusLabel.setText("Status: Login successful.");
                    frame.dispose();
                    new MainUI(username);
                } else {
                    // System.out.println("Wrong password.");
                    statusLabel.setText("Status: Wrong password.");
                }
            } else {
                // System.out.println("Username not found.");
                statusLabel.setText("Status: Username not found.");
            }
        }
    }
}
