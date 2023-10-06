package org.rentalsavg;

import java.util.Arrays;

public class StringHints {

    public boolean ifAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();

        Arrays.sort(achars);
        Arrays.sort(bchars);

        if (Arrays.equals(achars, bchars)) {
            return true;
        }

        return false;
    }
}
