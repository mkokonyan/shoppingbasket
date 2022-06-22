package Utls;

import java.util.Scanner;

public class Helpers {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void printErrorMessage(IllegalArgumentException ex) {
        System.out.println();
        System.out.println("*** " + ex.getMessage() + " ***");
        System.out.println("Please try again");
    }


}
