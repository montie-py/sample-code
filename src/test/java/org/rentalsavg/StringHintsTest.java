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
}