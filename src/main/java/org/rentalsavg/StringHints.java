package org.rentalsavg;

import java.util.Arrays;
import java.util.Set;

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

    public int atoi(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            ++index;
        }
        boolean positive = true;
        int result = 0;

        if (index < s.length() && Set.of('+', '-').contains(s.charAt(index))) {
            if (s.charAt(index) == '-') {
                positive = false;
            }
            ++index;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = Character.getNumericValue(s.charAt(index));
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            ++index;
        }

        if (!positive) {
            result = -result;
        }

        return result;
    }
}
