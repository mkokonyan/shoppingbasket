package repository;

import entities.User;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoggedUserRepo {
    public static final String LOGGED_USER_DB_PATH = "src\\db\\logged_user.txt";

    public static void persistLoggedUser(User user) {
        File file = new File(LOGGED_USER_DB_PATH);

        try {
            FileWriter writer = new FileWriter(file, false);

            writer.write(user.getUsername());
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.printf("\n*** Welcome %s ***\n", user.getUsername());
    }


    public static String readLoggedUsername() throws IOException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, User> usersMap = new HashMap<>();

        File file = new File(LOGGED_USER_DB_PATH);
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);

        String line = bReader.readLine();

        fReader.close();

        return line;
    }
}
