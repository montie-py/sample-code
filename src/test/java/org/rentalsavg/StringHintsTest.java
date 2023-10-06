package org.rentalsavg;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHintsTest {

    private static StringHints stringHints;

    @BeforeAll
    static void beforeAll() {
        stringHints = new StringHints();
    }

    @Test
    public void isAnagram() {
        assertAll(
                () -> assertTrue(stringHints.ifAnagram("anagram", "angaram")),
                () -> assertFalse(stringHints.ifAnagram("anagram", "aass")),
                () -> assertFalse(stringHints.ifAnagram("anagram", "anaaram"))
        );
    }
}