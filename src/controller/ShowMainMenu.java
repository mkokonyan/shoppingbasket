package controller;

import entities.User;
import repository.UsersRepo;
import service.Authentication;
import views.MainMenuView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class ShowMainMenu {
    public static void showMainMenu(Scanner scanner) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int option = MainMenuView.mainMenuView(scanner);
        switch (option) {

            case 1 -> {
                Authentication.login();
            }

            case 2 -> {
                Map<String, String> userToRegisterData = MainMenuView.registerMenu(scanner);

                User user = Authentication.register(userToRegisterData);

                UsersRepo.writeToDB(user);
            }

            case 3 ->  System.exit(0);

            default -> {
                System.out.print("\nPlease enter a number between 1 to 3\n");
                showMainMenu(scanner);
            }
        }
    }
}
