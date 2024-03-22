import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI implements ActionListener {
    // สร้างตัวแปรไว้เก็บข้อมูลของ users
    HashMap<String, String> users = new HashMap<String, String>();

    // JFrame
    JFrame f = new JFrame();
    JButton login_Button = new JButton("Login");
    JLabel username_Label = new JLabel("Username:");
    JLabel password_Label = new JLabel("Password:");
    JTextField username_Field = new JTextField();
    JPasswordField password_Field = new JPasswordField();
    JLabel notify_Label = new JLabel();   
    
    // รับค่า data จาก Users
    LoginUI(HashMap<String, String> data) {
        // System.out.println(data);
        users = data; // เก็บข้อมูลที่รับมาไว้ใน users

        // UI
        username_Label.setBounds(20, 20, 70, 20);
        username_Field.setBounds(90, 20, 170, 20);

        password_Label.setBounds(20, 50, 70, 20);
        password_Field.setBounds(90, 50, 170, 20);

        login_Button.setBounds(95, 90, 100, 25);
        login_Button.setFocusable(false);
        login_Button.addActionListener(this);

        notify_Label.setBounds(10, 120, 200, 20);
        notify_Label.setFont(new Font(null, Font.PLAIN, 11));


        // JFrame add
        f.add(username_Label);
        f.add(username_Field);
        f.add(password_Label);
        f.add(password_Field);
        f.add(login_Button);
        f.add(notify_Label);

        // JFrame
        f.setTitle("Login Page");
        f.setSize(300, 180);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // เช็คถ้ากด button login
        if (e.getSource() == login_Button) {
            // get ค่าใน field
            String username = username_Field.getText();
            String password = String.valueOf(password_Field.getPassword());
            
            // เช็ค username ที่รับมาตรงกับค่าใน data ไหม
            if (users.containsKey(username)) {

                // ต่อมาเช็ค password
                if (users.get(username).equals(password)) {
                    notify_Label.setText("Login succesful.");
                    f.dispose();
                    new Newpage(username);
                } else {
                    notify_Label.setText("Wrong password.");
                }
            } else {
                notify_Label.setText("Username not found!");
            }
        }
    }
}
