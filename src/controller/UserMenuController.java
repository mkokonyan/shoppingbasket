package controller;

import entities.Product;
import entities.User;
import services.ProductService;
import services.PurchaseService;
import services.UserService;
import views.UserMenuView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class UserMenuController {
    public static User showUserMenu(Scanner scanner) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        User loggedUser = UserService.getLoggedUser();
        Map<String, User> usersAsMap = UserService.getUsersAsMap();

        System.out.println(usersAsMap);

        int option = UserMenuView.userMenu(scanner);

        switch (option) {

            case 1 -> {
                System.out.println("\n" + ProductService.getAllProducts());
                showUserMenu(scanner);
            }

            case 2 -> {
                System.out.print("Please enter product ID ");
                int productIdToAdd = Integer.parseInt(scanner.nextLine());
                Product productToAdd = ProductService.getAllProductsAsList().stream().filter(e -> e.getId() == productIdToAdd).findFirst().get();

                PurchaseService.addProductToBasket(loggedUser, productToAdd);

                showUserMenu(scanner);
//
            }

            case 3 -> {

            }

            case 4 -> {

            }

            case 5 -> System.exit(0);

            default -> {
                System.out.print("\nPlease enter a number between 1 to 5\n");

                showUserMenu(scanner);
            }
        }

        return loggedUser;
    }

}
