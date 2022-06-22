package services;

import utls.Helpers;
import entities.User;
import repository.UsersRepo;
import services.validators.LoginValidators;
import services.validators.RegisterValidators;
import views.MainMenuView;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class AuthenticationService {

    public static User login(Map<String, String> userLoginData) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String, User> usersMap = UsersRepo.readAllUsers();

        String username = userLoginData.get("Username");
        String password = userLoginData.get("Password");

        try {
            LoginValidators.validateCredentials(usersMap, username, password);

        } catch (IllegalArgumentException ex) {

            Helpers.printErrorMessage(ex);

            userLoginData = MainMenuView.loginMenu(Helpers.getScanner());

            return AuthenticationService.login(userLoginData);
        }

        return UsersRepo.findUserByUsername(username);

    }

    public static User register(Map<String, String> userToRegisterData) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String, User> usersMap = UsersRepo.readAllUsers();

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

           return AuthenticationService.register(userToRegisterData);
        }

        return new User(username, password, firstName, totalBalance);
    }


}
