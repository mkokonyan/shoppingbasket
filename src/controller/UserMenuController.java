package controller;

import entities.Product;
import entities.User;
import services.UserService;
import views.UserMenuView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserMenuController {
    public static User showUserMenu(Scanner scanner) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        User loggedUser = UserService.getLoggedUser();
        Map<String, User> usersAsMap = UserService.getUsersAsMap();

        int option = UserMenuView.userMenu(scanner);

        while (true) {
            switch (option) {

                case 1 -> UserService.getAllProducts();
                case 2 -> {
                    System.out.print("Please enter product ID ");

                    int productIdToAdd = Integer.parseInt(scanner.nextLine());

                    loggedUser = UserService.getUpdatedUser(loggedUser, productIdToAdd);
                }
                case 3 -> {
                    List<Product> productsList = UserService.getAllProductsInBasket(loggedUser);

                    UserService.getProductsInfo(productsList);
                }
                case 4 -> UserService.getUserBalance(loggedUser);
                case 5 -> UserService.makePurchase(loggedUser, usersAsMap);
                case 6 -> System.exit(0);
                default -> {
                    System.out.print("\nPlease enter a number between 1 to 5\n");
                }
            }
            option = UserMenuView.userMenu(scanner);
        }
    }
}
