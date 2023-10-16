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

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String plainString = sb.toString();

        String reverse = reverse(plainString);
        if (reverse.equals(plainString)) {
            return true;
        }
        return false;
    }

    private String reverse(String plainString) {
        char[] charArray = plainString.toCharArray();

        int left = 0;
        int right = charArray.length-1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }
}
