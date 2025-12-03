package UTILITIES;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Password {
    public static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength)throws Exception {
        PBEKeySpec spec = new PBEKeySpec(password, salt,iterations, keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        return skf.generateSecret(spec).getEncoded();
    }
}
