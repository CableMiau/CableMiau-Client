package GUI;
import ACTIONS.LoginActions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class login {
    public static void login_gui() {
        JFrame frame = new JFrame("CableMiau - Login");

        JLabel srvLabel = new JLabel("Server IP:");
        JTextField srvField = new JTextField();

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JCheckBox checkBox = new JCheckBox("keep log in data?");
        JCheckBox passwordBox = new JCheckBox("show password?");
        char defaultEcho = passwordField.getEchoChar();

        JButton loginButton = new JButton("Log in");

        frame.setLayout(new GridLayout(9,1));

        frame.add(srvLabel);
        frame.add(srvField);

        frame.add(usernameLabel);
        frame.add(usernameField);

        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(passwordBox);

        frame.add(checkBox);
        frame.add(loginButton);

        frame.getRootPane().setDefaultButton(loginButton);
        frame.setSize(400,200);
        frame.setVisible(true);

        //logo loading - use normal logo by failed
        try {
            frame.setIconImage(ImageIO.read(new File("src/GUI/ethernet.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(_ -> LoginActions.loginAction(srvField,usernameField, passwordField));
        passwordBox.addActionListener(_ -> LoginActions.showPasswordAction(passwordBox, passwordField, defaultEcho));
    }
}
