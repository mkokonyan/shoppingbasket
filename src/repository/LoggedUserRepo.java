package repository;

import entities.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

}
