package views;

import utls.Helpers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminMenuView {
    public static int adminMenu(Scanner scanner) {

        int[] validOptions = new int[] {1, 2};

        System.out.println("\nAdministrator menu:");
        System.out.println("\t1) Add product");
        System.out.println("\t2) Exit");
        System.out.print("Choose an option: ");

        return Helpers.getOptionIndex(scanner, validOptions);

    }

    public static Map<String, String> productAddMenu(Scanner scanner) {
        Map<String, String> productData = new LinkedHashMap<>();

        System.out.println("\nAdd product:");

        System.out.print("\tEnter product name: ");
        String name = scanner.nextLine();
        productData.put("Name", name);

        System.out.print("\tEnter product price: ");
        String price = scanner.nextLine();
        productData.put("Price", price);

        return productData;
    }
}
