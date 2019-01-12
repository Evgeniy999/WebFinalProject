package by.epam.interpol.coding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCode {
    private static Logger LOGGER = LogManager.getLogger(PasswordCode.class);
    private static final String ENCODING_TYPE = "MD5";

    public static String encode(String password){
        StringBuilder stringBuilder = new StringBuilder();

        try {

            MessageDigest md5 = MessageDigest.getInstance(ENCODING_TYPE);
            byte[] bytes = md5.digest(password.getBytes());

            for(byte b : bytes){
                //stringBuilder.append(String.format("%02X ", b));//todo изменить
                stringBuilder.append(String.format("%02X", b));//todo изменить

            }

        }
        catch (NoSuchAlgorithmException e) {
            LOGGER.error("Can not encode password");
        }

        return stringBuilder.toString();
    }

    public static boolean comparePasswords(String pass1, String pass2){
        return pass1.trim().equals(pass2.trim());
    }

}
