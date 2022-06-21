package service.validators;

public class RegisterValidators {

    public static void validatePassword(String password, String repeatPassword) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }
        if (password.matches(".*[\s].*")) {
            throw new IllegalArgumentException("Password must not have whitespace characters");
        }
        if (!password.equals(repeatPassword)) {
            throw new IllegalArgumentException("Password do not match. Try again");
        }

    }

}
