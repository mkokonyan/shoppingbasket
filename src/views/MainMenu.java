package views;

import entities.User;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenu {
    public static int mainMenuView(Scanner scanner) {
        System.out.println("\nMain menu:");
        System.out.println("\t1) Log in");
        System.out.println("\t2) Register");
        System.out.println("\t3) Exit");
        System.out.print("Choose an option: ");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (IllegalArgumentException ex) {
            return -1;
        }
    }

    public static Map<String, String> registerMenu(Scanner scanner) {
        Map<String, String> userRegisterData = new LinkedHashMap<>();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        userRegisterData.put("Username", username);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userRegisterData.put("Password", password);

        System.out.print("Confirm password: ");
        String repeatedPassword = scanner.nextLine();
        userRegisterData.put("Repeated_Password", repeatedPassword);


        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        userRegisterData.put("First_name", firstName);


        System.out.print("Total balance: ");
        String totalBalance = scanner.nextLine();
        userRegisterData.put("Total_balance", totalBalance);


        return userRegisterData;

    }
}
