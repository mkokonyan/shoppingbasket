package service;

import entities.User;
import repository.UsersRepo;
import service.validators.RegisterValidators;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Authentication {

    public static void login() {
    }

    public static User register(Map<String, String> userToRegisterData) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String, User> usersMap = UsersRepo.readUsers();


        String username = userToRegisterData.get("Username");
        String password = userToRegisterData.get("Password");
        String repeatedPassword = userToRegisterData.get("Repeated_Password");
        String firstName = userToRegisterData.get("First_name");
        double totalBalance = Double.parseDouble(userToRegisterData.get("Total_balance"));

        try {
            RegisterValidators.validatePassword(password, repeatedPassword);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }


        return new User(username, password, firstName, totalBalance);
    }

}
