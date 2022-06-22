package views;

import utls.Helpers;

import java.util.Scanner;

public class UserMenuView {
    public static int userMenu(Scanner scanner) {

        int[] validOptions = new int[] {1, 2, 3, 4};

        System.out.println("\nUser menu:");
        System.out.println("\t1) Show products");
        System.out.println("\t2) Add product to basket");
        System.out.println("\t3) Show products in basket");
        System.out.println("\t4) Purchase");
        System.out.println("\t5) Exit");
        System.out.print("Choose an option: ");

        return Helpers.getOptionIndex(scanner, validOptions);

    }
}
