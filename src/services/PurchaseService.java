package services;

import entities.Product;
import entities.User;

public class PurchaseService {


    public static User addProductToBasket(User loggedUser, Product productToAdd) {

        double newBalance = loggedUser.getTotalBalance() - productToAdd.getPrice();

        if (newBalance < 0) {
            System.out.println("You can't afford this product");
        } else {
            loggedUser.setTotalBalance(newBalance);

            System.out.printf("\n*** You successfully added %s to your basket ***\n", productToAdd.getName());
            loggedUser.addProduct(productToAdd);
        }

        return loggedUser;
    }
}
