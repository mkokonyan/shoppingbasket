package controller;

import entities.User;
import repository.LoggedUserRepo;
import repository.UsersRepo;
import services.UserService;
import views.MainMenuView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class MainMenuController {
    public static User showMainMenu(Scanner scanner) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        User user = null;
        int option = MainMenuView.mainMenu(scanner);
        switch (option) {

            case 1 -> {
                Map<String, String> userLoginData = MainMenuView.loginMenu(scanner);

                user = UserService. login(userLoginData);

                LoggedUserRepo.persistLoggedUser(user);
            }

            case 2 -> {
                Map<String, String> userToRegisterData = MainMenuView.registerMenu(scanner);

                user = UserService.register(userToRegisterData);

                UsersRepo.addNewUser(user);

                LoggedUserRepo.persistLoggedUser(user);
            }

            case 3 ->  System.exit(0);

            default -> {
                System.out.print("\nPlease enter a number between 1 to 3\n");

                showMainMenu(scanner);
            }
        }

        return user;
    }
}
