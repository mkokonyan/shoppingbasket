import controller.MenuController;
import controller.ProductController;
import entities.Product;
import entities.User;
import repository.ProductsRepo;
import utls.Helpers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User loggedUser = MenuController.showMainMenu(Helpers.getScanner());

        if (loggedUser.getUsername().equals("admin")) {

            Product product = ProductController.showAdminMenu(Helpers.getScanner());




        } else {

        }
    }
}

