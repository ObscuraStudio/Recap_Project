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

    // Test cases for isCommonPassword method

    @Test
    public void isCommonPassword_shouldReturnTrue() {
        assertTrue(Main.isCommonPassword("password"));
    }

    @Test
    public void isCommonPassword_shouldReturnFalse() {
        assertFalse(Main.isCommonPassword("HardPassword123"));
    }

    // Test cases for isValid method

    @Test
    public void isValid_failsWhenTooShort() {
        assertFalse(Main.isValid("Hz1"));
    }

    @Test
    public void isValid_failsWhenNoDigit() {
        assertFalse(Main.isValid("Horizont"));
    }

    @Test
    public void isValid_failsWhenNoMixedCase() {
        assertFalse(Main.isValid("horizon11"));
    }

    @Test
    public void isValid_failsWhenCommon() {
        assertFalse(Main.isValid("password"));
    }

    @Test
    public void isValid_failsWhenNull() {
        assertFalse(Main.isValid(null));
    }

    @Test
    public void isValid_passesWhenValid() {
        assertTrue(Main.isValid("Horizon11!"));
    }

    // Test cases for generateSecurePassword method

    @Test
    public void generatedPasswordHasRequestedLength() {
        String pw = Main.generateSecurePassword(12, "!@#$");
        assertEquals(12, pw.length());
    }

    @Test
    public void generatedPasswordPassesValidation() {
        for (int i = 0; i < 100; i++) {
            String pw = Main.generateSecurePassword(8, "!@#$");
            assertTrue(Main.isValid(pw), "Failed for: " + pw);
        }
    }

    @Test
    public void generatedPasswordIsRandom() {
        String pw1 = Main.generateSecurePassword(16, "!@#$");
        String pw2 = Main.generateSecurePassword(16, "!@#$");
        assertNotEquals(pw1, pw2);
    }

    @Test
    public void rejectsLengthBelowMinimum() {
        assertThrows(IllegalArgumentException.class,
                () -> Main.generateSecurePassword(5, "!@#$"));
    }

    @Test
    public void handlesNullSpecials() {
        String pw = Main.generateSecurePassword(8, null);
        assertTrue(Main.isValid(pw));
    }
}