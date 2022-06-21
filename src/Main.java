import entities.User;
import repository.UsersRepo;
import service.Authentication;
import views.MainMenu;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Scanner scanner = new Scanner(System.in);

        boolean isValidOption = true;

        do {
            int option = MainMenu.mainMenuView(scanner);
            switch (option) {
                case 1 -> {
                    Authentication.login();

                }

                case 2 -> {
                    Map<String, String> userToRegisterData = MainMenu.registerMenu(scanner);

                    User user = Authentication.register(userToRegisterData);

                    UsersRepo.writeToDB(user);
                }

                case 3 -> System.exit(0);

                default -> {
                    isValidOption = false;
                    System.out.print("\nPlease enter a number between 1 to 3\n");
                }
            }

        } while (!isValidOption);
    }
}