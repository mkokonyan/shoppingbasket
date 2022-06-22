package repository;

import entities.Product;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProductsRepo {
    public static final String PRODUCTS_DB_PATH = "src\\db\\products.txt";

    public static void addNewProduct(Product product) {
        File file = new File(PRODUCTS_DB_PATH);

        try {
            FileWriter writer = new FileWriter(file, true);

            writer.write(String.format("Name: %s, Price: %.2f\n",
                    product.getName(), product.getPrice()));
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, Product> readAllProducts() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Product> productsMap = new HashMap<>();

        File file = new File(PRODUCTS_DB_PATH);
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);

        String line;
        while ((line = bReader.readLine()) != null) {

            String[] productData = line.split(", ");

            Map<String, String> productMap = new LinkedHashMap<>();

            for (String data : productData) {
                String key = data.split(": ")[0];
                String value = data.split(": ")[1];

                productMap.put(key, value);
            }

            Object productAsObj = new Product();
            Product product = (Product) productAsObj.getClass()
                    .getConstructor(String.class, double.class)
                    .newInstance(
                            productMap.get("Name"), Double.parseDouble(productMap.get("Price")));

            productsMap.put(product.getName(), product);

        }

        fReader.close();

        return productsMap;
    }

    public static Product findProductByName(String name) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String, Product> productsMap = ProductsRepo.readAllProducts();

        return productsMap.get(name);
    }

}
