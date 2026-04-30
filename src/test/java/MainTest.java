import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // Test cases for hasMinLength method

    @Test
    public void hasMinLength_stringWith8_shouldReturnTrue() {
        assertTrue(Main.hasMinLength("password", 8));
    }

    @Test
    public void hasMinLength_stringWith7_shouldReturnFalse() {
        assertFalse(Main.hasMinLength("passwor", 8));
    }

    @Test
    public void hasMinLength_stringWith9_shouldReturnTrue() {
        assertTrue(Main.hasMinLength("passwords", 8));
    }

    @Test
    public void hasMinLength_insertNull_shouldReturnFalse() {
        assertFalse(Main.hasMinLength(null, 8));
    }

    @Test
    public void hasMinLength_stringIsEmpty_shouldReturnFalse() {
        assertFalse(Main.hasMinLength("", 8));
    }

    // Test cases for containsDigit method

    @Test
    public void containsDigit_RejectsArabicDigit_shouldReturnFalse() {
        assertFalse(Main.containsDigit("password٥"));
    }

    @Test
    public void containsDigit_RejectsFullwidthDigit_shouldReturnFalse() {
        assertFalse(Main.containsDigit("password５"));
    }

    @Test
    public void containsDigit_AcceptsAsciiDigit_shouldReturnTrue() {
        assertTrue(Main.containsDigit("password5"));
    }

    @Test
    public void containsDigit_NullSafe_shouldReturnFalse() {
        assertFalse(Main.containsDigit(null));
    }

    @Test
    public void containsDigit_noDigit_shouldReturnFalse() {
        assertFalse(Main.containsDigit("password"));
    }

    // Test cases for containsMixedCase method

    @Test
    public void containsMixedCase_onlyUpperCase_shouldReturnFalse() {
        assertFalse(Main.containsMixedCase("PASSWORD"));
    }

    @Test
    public void containsMixedCase_onlyLowerCase_shouldReturnFalse() {
        assertFalse(Main.containsMixedCase("password"));
    }

    @Test
    public void containsMixedCase_mixedCase_shouldReturnTrue() {
        assertTrue(Main.containsMixedCase("Password"));
    }

    @Test
    public void containsMixedCase_onlyOneChar_shouldReturnFalse() {
        assertFalse(Main.containsMixedCase("p"));
    }

    @Test
    public void containsMixedCase_nullSafe_shouldReturnFalse() {
        assertFalse(Main.containsMixedCase(null));
    }

}