package UTILITIES;

import java.net.InetAddress;

public class IP {
    public static boolean checkIP(String IP) {
        try {
            InetAddress address = InetAddress.getByName(IP);
            return address.getHostAddress().equals(IP);
        } catch (Exception e) {
            return false;
        }
    }
}
