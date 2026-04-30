public class Main {

    public static void main() {
        System.out.println("Hello World");
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
}
