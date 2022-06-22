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

        while (true) {
            switch (option) {

                case 1 -> {
                    System.out.println("\n" + ProductService.getAllProducts());

                }

                case 2 -> {
                    System.out.print("Please enter product ID ");

                    int productIdToAdd = Integer.parseInt(scanner.nextLine());

                    Product productToAdd = ProductService.getAllProductsAsList().stream().filter(e -> e.getId() == productIdToAdd).findFirst().get();

                    User updatedUser = PurchaseService.addProductToBasket(loggedUser, productToAdd);
                    loggedUser = updatedUser;
                }

                case 3 -> {
                    List<Product> productsList = UserService.getAllProductsInBasket(loggedUser);

                    if (!productsList.isEmpty()) {
                        System.out.println("\nCurrently added products in basket:");
                        System.out.println(productsList.stream()
                                .map(Product::getName)
                                .collect(Collectors.joining(", ")));
                        System.out.printf("Total ammount: %s\n", productsList.stream()
                                .map(Product::getPrice)
                                .mapToDouble(e -> e)
                                .sum());
                    } else {
                        System.out.println("\n*** You do not have purchased items yet ***");
                    }
                }

                case 4 -> {
                    System.out.printf("\n*** Your current balance is %.2f ***\n", loggedUser.getTotalBalance());
                }

                case 5 -> {
                   if (!loggedUser.getProductList().isEmpty()) {
                       usersAsMap.put(loggedUser.getUsername(), loggedUser);
                       UserService.updateUsers(usersAsMap);
                       System.out.println("\n*** You successfully made purchase! ***");
                   } else {
                       System.out.println("\n*** Your basket is empty! ***");

                   }

                }
                case 6 -> System.exit(0);


                default -> {
                    System.out.print("\nPlease enter a number between 1 to 5\n");

                }
            }
            option = UserMenuView.userMenu(scanner);
        }
    }

}
