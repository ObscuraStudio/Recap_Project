import java.security.SecureRandom;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Password Validator!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        List<String> errors = getValidationErrors(password);
        if (errors.isEmpty()) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid:");
            for (String error : errors) {
                System.out.println("  - " + error);
            }
        }
        scanner.close();
    }

    public static boolean hasMinLength(String password, int min) {
        if (password == null) {
            return false;
        }
        return password.length() >= min;
    }

    public static boolean containsDigit(String password) {
        if (password == null) {
            return false;
        }
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    public static boolean containsMixedCase(String password) {
        if (password == null) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        for (char c : password.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                hasUpper = true;
            } else if (c >= 'a' && c <= 'z') {
                hasLower = true;
            }
            if (hasUpper && hasLower) {
                return true;
            }
        }
        return false;
    }

    private static final Set<String> COMMON_PASSWORDS = Set.of(
            "password",
            "passwort1",
            "password123",
            "p1234567",
            "aa34567"
    );

    public static boolean isCommonPassword(String password) {
        if (password == null) {
            return false;
        }
        String normalized = password.trim().toLowerCase();
        return COMMON_PASSWORDS.contains(normalized);

    }

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    public static String generateSecurePassword(int length, String allowedSpecials) {
        if (length < 8) {
            throw new IllegalArgumentException("Length must be at least 8");
        }
        if (allowedSpecials == null) {
            allowedSpecials = "";
        }

        String allChars = UPPER + LOWER + DIGITS + allowedSpecials;

        // Step 1: guarantee one of each required category
        char[] password = new char[length];
        password[0] = UPPER.charAt(RANDOM.nextInt(UPPER.length()));
        password[1] = LOWER.charAt(RANDOM.nextInt(LOWER.length()));
        password[2] = DIGITS.charAt(RANDOM.nextInt(DIGITS.length()));

        // Step 2: fill the rest from the full pool
        for (int i = 3; i < length; i++) {
            password[i] = allChars.charAt(RANDOM.nextInt(allChars.length()));
        }

        // Step 3: shuffle so forced characters aren't predictably positioned
        shuffle(password);

        return new String(password);
    }

    private static void shuffle(char[] array) {
        // Fisher-Yates shuffle
        for (int i = array.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static boolean isValid(String password) {
        return getValidationErrors(password).isEmpty();

    }

    public static List<String> getValidationErrors(String password) {
        List<String> errors = new ArrayList<>();

        if (password == null || password.isEmpty()) {
            errors.add("Password must not be empty.");
            return errors;
        }
        if (!hasMinLength(password, 8)) {
            errors.add("Password must be at least 8 characters long.");
        }
        if (!containsDigit(password)) {
            errors.add("Password must contain at least one digit (0-9).");
        }
        if (!containsMixedCase(password)) {
            errors.add("Password must contain both uppercase and lowercase letters.");
        }
        if (isCommonPassword(password)) {
            errors.add("Password is on the list of common/weak passwords.");
        }
        return errors;
    }
}
