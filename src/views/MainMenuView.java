package views;

import utls.Helpers;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenuView {
    public static int mainMenu(Scanner scanner) {
        int[] validOptions = new int[] {1, 2, 3};

        System.out.println("\nMain menu:");
        System.out.println("\t1) Log in");
        System.out.println("\t2) Register");
        System.out.println("\t3) Exit");
        System.out.print("Choose an option: ");

        return Helpers.getOptionIndex(scanner, validOptions);
    }



    public static Map<String, String> loginMenu(Scanner scanner) {
        Map<String, String> userLoginData = new LinkedHashMap<>();

        System.out.println("\nLogin as:");

        System.out.print("\tEnter your username: ");
        String username = scanner.nextLine();
        userLoginData.put("Username", username);

        System.out.print("\tEnter password: ");
        String password = scanner.nextLine();
        userLoginData.put("Password", password);

        return userLoginData;
    }


    public static Map<String, String> registerMenu(Scanner scanner) {
        Map<String, String> userRegisterData = new LinkedHashMap<>();


        System.out.println("\nRegister form:");

        System.out.print("\tEnter your username: ");
        String username = scanner.nextLine();
        userRegisterData.put("Username", username);

        System.out.print("\tEnter password: ");
        String password = scanner.nextLine();
        userRegisterData.put("Password", password);

        System.out.print("\tConfirm password: ");
        String repeatedPassword = scanner.nextLine();
        userRegisterData.put("Repeated_Password", repeatedPassword);


        System.out.print("\tEnter your first name: ");
        String firstName = scanner.nextLine();
        userRegisterData.put("First_name", firstName);


        System.out.print("\tEnter your total balance: ");
        String totalBalance = scanner.nextLine();
        userRegisterData.put("Total_balance", totalBalance);


        return userRegisterData;

    }
}
