
package controller;

import util.InputUtils;

/**
 *
 * @author LENOVO
 */
public class Menu {
    public static int chooseInputOption(){
            System.out.println("-------------------------------------------");
            System.out.println("1. Create fruit.");
            System.out.println("2. View Order.");
            System.out.println("3. Shoping.");
            System.out.println("4. Exit");
            System.out.println("--------------------------------------------");
        int option = InputUtils.inputOption(1, 4);
        return option;
    }
}
