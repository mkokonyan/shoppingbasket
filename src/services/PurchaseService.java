package services;

import entities.Product;
import entities.User;

public class PurchaseService {


    public static void addProductToBasket(User loggedUser, Product productToAdd) {


        loggedUser.addProduct(productToAdd);
    };
}
