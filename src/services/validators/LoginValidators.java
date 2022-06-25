package services.validators;

import entities.User;

import java.util.Map;

public class LoginValidators {


    public static void validateCredentials(Map<String, User> usersMap, String username, String password) {
        if (!usersMap.containsKey(username)) {
            throw new IllegalArgumentException("Username does not exist");
        }

        User user = usersMap.get(username);

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }
}
