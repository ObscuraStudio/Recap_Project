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
}

