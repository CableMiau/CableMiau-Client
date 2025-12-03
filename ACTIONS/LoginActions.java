package ACTIONS;

import UTILITIES.IP;
import UTILITIES.Password;

import javax.swing.*;
import java.security.SecureRandom;
import java.util.Base64;

public class LoginActions {
    public static void loginAction(JTextField srvField, JTextField usernameField, JPasswordField passwordField) {
        String ipadd = srvField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (!IP.checkIP(ipadd)) {
            JOptionPane.showMessageDialog(null, "Die IP "+ipadd+" ist keine richtige IP", "CableMeow Error", JOptionPane.ERROR_MESSAGE);
        }

        SecureRandom randomPassword = new SecureRandom();
        byte[] salt = new byte[16];
        randomPassword.nextBytes(salt);
        try {
            byte[] hash = Password.hashPassword(password.toCharArray(),salt, 65536, 256);
            System.out.println("Salt: "+ Base64.getEncoder().encodeToString(salt));
            System.out.println("Hash: "+ Base64.getEncoder().encodeToString(hash));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }
    public static void showPasswordAction(JCheckBox passwordBox, JPasswordField passwordField, char defaultEcho) {
        if (passwordBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar(defaultEcho);
        }
    }
}
