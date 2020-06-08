package de.byPixels.RemoteClient.utils;

import java.util.Base64;

public class Crypter {
    private static String code;

    public static String encrypt(final String text) {
        try {
            setCode(Base64.getEncoder().encodeToString(text.getBytes()));
            return getCode();
        }
        catch (Exception e) {
            System.out.println("ERROR! 2");
            return null;
        }
    }

    public static String getCode() {
        return Crypter.code;
    }

    public static String decode(final String code) {
        try {
            return new String(Base64.getDecoder().decode(code));
        }
        catch (Exception e) {
            System.out.println("ERROR! #3");
            return null;
        }
    }

    public static void setCode(final String code) {
        Crypter.code = code;
    }

    static {
        Crypter.code = null;
    }
}