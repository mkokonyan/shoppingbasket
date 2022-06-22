package service;

import controller.ProductController;
import entities.Product;
import repository.ProductsRepo;
import service.validators.ProductValidators;
import utls.Helpers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ProductManager {
    public static Product addToShop(Map<String, String> productData) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String, Product> productsMap = ProductsRepo.readAllProducts();

        String name = productData.get("Name");
        String priceAsString = productData.get("Price");

        double price = 0;

        try {
            ProductValidators.validateName(productsMap, name);
            price = ProductValidators.validatePrice(priceAsString);

        }  catch (IllegalArgumentException ex) {

            Helpers.printErrorMessage(ex);

            return ProductController.showAdminMenu(Helpers.getScanner());

        }

        return new Product(name, price);
    }
}
