package entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String username;
    private String password;
    private String firstName;
    private double totalBalance;

    private List<Product> productList;

    public User() {
    }

    public User(String username, String password, String firstName, double totalBalance) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.totalBalance = totalBalance;
        this.productList = new ArrayList<>();
    }

    public User(String username, String password, String firstName, double totalBalance, List<Product> productList) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.totalBalance = totalBalance;
        this.productList = productList;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public String getProductsAsString() {
        return Collections.unmodifiableList(productList).stream().map(Product::getName).collect(Collectors.joining("-"));
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", totalBalance=" + totalBalance +
                ", productList=" + productList +
                '}';
    }
}
