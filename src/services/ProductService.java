package services;

import controller.AdminViewController;
import entities.Product;
import repository.ProductsRepo;
import services.validators.ProductValidators;
import utls.Helpers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class ProductService {
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

            return AdminViewController.showAdminMenu(Helpers.getScanner());

        }
        Product product = new Product(name, price);

        ProductsRepo.addNewProduct(product);
        return product;
    }
}
