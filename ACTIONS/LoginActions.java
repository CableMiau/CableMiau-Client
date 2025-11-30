package ACTIONS;

import javax.swing.*;

public class LoginActions {
    public static void loginAction(JTextField usernameField, JPasswordField passwordField) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        System.out.println(username);
        System.out.println(password);
    }
    public static void showPasswordAction(JCheckBox passwordBox, JPasswordField passwordField, char defaultEcho) {
        if (passwordBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar(defaultEcho);
        }
    }
}
