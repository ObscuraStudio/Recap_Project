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
}