import Utls.Helpers;
import controller.ShowMainMenu;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ShowMainMenu.showMainMenu(Helpers.getScanner());


    }
}

