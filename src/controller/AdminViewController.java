package controller;

import entities.Product;
import services.ProductService;
import views.AdminMenuView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class AdminViewController {

    public static Product showAdminMenu(Scanner scanner) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        Product product = null;
        int option = AdminMenuView.adminMenu(scanner);

        switch (option) {

            case 1 -> {
                Map<String, String> productData = AdminMenuView.productAddMenu(scanner);

                product = ProductService.addToShop(productData);

            }

            case 2 -> System.exit(0);

            default -> {
                System.out.print("\nPlease enter a number between 1 to 2\n");

            }
        }

        return product;
    }
}

