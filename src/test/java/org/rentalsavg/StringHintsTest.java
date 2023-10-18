package org.rentalsavg;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHintsTest {

    private static StringHints stringHints;

    @BeforeAll
    static void beforeAll() {
        stringHints = new StringHints();
    }

    @Test
    @DisplayName("It should return TRUE if both of words are anagrams")
    public void isAnagram() {
        assertAll(
                () -> assertTrue(stringHints.ifAnagram("anagram", "angaram")),
                () -> assertFalse(stringHints.ifAnagram("anagram", "aass")),
                () -> assertFalse(stringHints.ifAnagram("anagram", "anaaram"))
        );
    }

    @Test
    @DisplayName("Test whether a string is a valid palindrome")
    public void isPalindrome() {
        assertAll(
                () -> assertTrue(stringHints.isPalindrome("A man, a plan, a canal: Panama")),
                () -> assertFalse(stringHints.isPalindrome("race a car"))
        );
    }

    @Test
    @DisplayName("Test whether atoi() function works")
    public void atoi() {
        assertAll(
                () -> assertEquals(34, stringHints.atoi("0034")),
                () -> assertEquals(2147483647, stringHints.atoi("200000000000000000000000")),
                () -> assertEquals(-2147483648, stringHints.atoi("-200000000000000000000000")),
                () -> assertEquals(-2147483648, stringHints.atoi(" -200000000000000000000000")),
                () -> assertEquals(-20, stringHints.atoi(" -20")),
                () -> assertEquals(20, stringHints.atoi(" 20")),
                () -> assertEquals(-20, stringHints.atoi(" -0020")),
                () -> assertEquals(20, stringHints.atoi(" 0020")),
                () -> assertEquals(0, stringHints.atoi("")),
                () -> assertEquals(0, stringHints.atoi(" ")),
                () -> assertEquals(0, stringHints.atoi("  ")),
                () -> assertEquals(2, stringHints.atoi("  2"))
        );
    }
}