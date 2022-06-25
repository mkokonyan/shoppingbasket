package services.validators;

import entities.User;

import java.util.Map;

public class RegisterValidators {

    public static void validateUsername (Map<String, User> users, String username) {
        if (username.length() < 3) {
            throw new IllegalArgumentException("Username must be at least 3 symbols");
        }
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
    }

    public static void validatePassword(String password, String repeatPassword) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one digit");
        }
        if (password.matches(".*[\s].*")) {
            throw new IllegalArgumentException("Password must not have whitespace characters");
        }
        if (!password.equals(repeatPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }

    public static void validateFirstName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 symbols");
        }
    }

    public static double validateTotalBalance(String totalBalance) {
        try {
             return Double.parseDouble(totalBalance);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Please enter valid balance");
        }
    }
}
