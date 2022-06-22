package controller;

import entities.Product;
import entities.User;
import services.ProductService;
import services.PurchaseService;
import services.UserService;
import views.UserMenuView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserMenuController {
    public static User showUserMenu(Scanner scanner) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        User loggedUser = UserService.getLoggedUser();
        Map<String, User> usersAsMap = UserService.getUsersAsMap();

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

                User updatedUser = PurchaseService.addProductToBasket(loggedUser, productToAdd);

                showUserMenu(scanner);

            }

            case 3 -> {
                List<Product> productsList = UserService.getAllProductsInBasket(loggedUser);

                if (!productsList.isEmpty()) {
                    System.out.println("\nCurrently added products in basket\n");
                    System.out.println(productsList.stream()
                            .map(Product::getName)
                            .collect(Collectors.joining(", ")));
                    System.out.printf("\nTotal ammount: %s\n", productsList.stream()
                            .map(Product::getPrice)
                            .mapToDouble(e->e)
                            .sum());
                } else {
                    System.out.println("\nYou do not have purchased items yet");
                }

                showUserMenu(scanner);
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
