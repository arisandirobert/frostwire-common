package org.appwork.utils;

import java.util.Locale;

public class StringUtils {

    /**
     * Returns wether a String is null,empty, or contains whitespace only
     * 
     * @param ip
     * @return
     */
    public static boolean isEmpty(String ip) {
        return ip == null || ip.trim().length() == 0;
    }

    /**
     * @param pass
     * @param pass2
     * @return
     */
    public static boolean equalsIgnoreCase(String pass, String pass2) {
        if (pass == pass2) return true;
        if (pass == null && pass2 != null) return false;
        return pass.equalsIgnoreCase(pass2);
    }

    /**
     * @param pass
     * @param pass2
     * @return
     */
    public static boolean equals(String pass, String pass2) {
        if (pass == pass2) return true;
        if (pass == null && pass2 != null) return false;
        return pass.equals(pass2);
    }
}
