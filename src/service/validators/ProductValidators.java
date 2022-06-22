package service.validators;

import entities.Product;

import java.util.Map;

public class ProductValidators {

    public static void validateName (Map<String, Product> products, String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("Product name must be at least 2 symbols");
        }
        if (products.containsKey(name)) {
            throw new IllegalArgumentException("Product already exists");
        }
    }

    public static double validatePrice(String price) {
        try {
            return Double.parseDouble(price);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Please enter valid price");
        }
    }
}
