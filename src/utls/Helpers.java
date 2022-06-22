package utls;

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

    public static int getOptionIndex(Scanner scanner, int[] validOptions) {
        try {
            int optionIndex = Integer.parseInt(scanner.nextLine()) - 1;
            return validOptions[optionIndex];
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException ex) {
            return -1;
        }
    }
}
