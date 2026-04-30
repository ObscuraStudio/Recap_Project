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

    // Test cases for hasUpperCase and hasLowerCase method
    

}