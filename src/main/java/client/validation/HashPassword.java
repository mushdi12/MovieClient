package client.validation;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public static String gethashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");


            byte[] passwordBytes = password.getBytes();

            byte[] hashBytes = digest.digest(passwordBytes);

            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {

                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return (hexString.toString());

        } catch (NoSuchAlgorithmException e) {
            return "не удалось за хэшировать пароль";
        }

    }
}
