package repository;

import entities.User;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class UsersRepo {
    public static final String USERS_DB_PATH = "src\\db\\users.txt";

    public static void addNewUser(User user) {
        File file = new File(USERS_DB_PATH);

        try {
            FileWriter writer = new FileWriter(file, true);

            writer.write(String.format("Username: %s, Password: %s, First_name: %s, Total_balance: %.2f, Products: %s\n",
                    user.getUsername(),user.getPassword(), user.getFirstName(), user.getTotalBalance(), user.getProductList()));
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, User> readAllUsers() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, User> usersMap = new HashMap<>();

        File file = new File(USERS_DB_PATH);
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);

        String line;
        while((line = bReader.readLine()) != null) {
            String [] userData = line.split(", ");
            Map<String, String> userMap = new LinkedHashMap<>();

            for (String data : userData) {
                String key = data.split(": ")[0];
                String value = data.split(": ")[1];

                userMap.put(key, value);
            }

            Object userAsObj = new User();
            User user = (User) userAsObj.getClass()
                    .getConstructor(String.class, String.class, String.class, double.class)
                    .newInstance(
                            userMap.get("Username"), userMap.get("Password"), userMap.get("First_name"), Double.parseDouble( userMap.get("Total_balance")));

            usersMap.put(user.getUsername(), user);

        }

        fReader.close();

        return usersMap;
    }

    public static User findUserByUsername(String username) throws IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Map<String, User> usersMap = UsersRepo.readAllUsers();

        return usersMap.get(username);
    }


}

