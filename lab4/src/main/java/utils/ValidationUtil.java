package utils;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return email.matches(regex);
    }

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }
}