package service;

import Utls.Helpers;
import entities.User;
import repository.UsersRepo;
import service.validators.RegisterValidators;
import views.MainMenuView;


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
        String totalBalanceAsString = userToRegisterData.get("Total_balance");

        double totalBalance = 0;
        try {

            RegisterValidators.validateUsername(usersMap, username);
            RegisterValidators.validatePassword(password, repeatedPassword);
            RegisterValidators.validateFirstName(firstName);
            totalBalance = RegisterValidators.validateTotalBalance(totalBalanceAsString);

        } catch (IllegalArgumentException ex) {

            Helpers.printErrorMessage(ex);

           userToRegisterData = MainMenuView.registerMenu(Helpers.getScanner());

           User user = Authentication.register(userToRegisterData);
        }

        return new User(username, password, firstName, totalBalance);
    }


}
