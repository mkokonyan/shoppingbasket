import controller.MainMenuController;
import controller.AdminViewController;
import controller.UserMenuController;
import entities.Product;
import entities.User;
import utls.Helpers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User loggedUser = MainMenuController.showMainMenu(Helpers.getScanner());

        if (loggedUser == null) {

            MainMenuController.showMainMenu(Helpers.getScanner());

        } else if (loggedUser.getUsername().equals("admin")) {

           while (true) {
               Product product = AdminViewController.showAdminMenu(Helpers.getScanner());
               System.out.printf("\n*** Successfully added %s to shop! ***\n", product.getName());
           }

        } else {

            UserMenuController.showUserMenu(Helpers.getScanner());

        }
    }
}
