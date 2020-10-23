/**
 *  This class is to start the ToDoLy application
 *  It contains only main method to be able to run the application
 *
 * @author Richa Gupta
 * @version 2020.10.09
 */
package main.java.IP.ToDoList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    public static void main (String [] args) {
       // new ToDoLy().startToDoLy();
       boolean r = isSpecialCharacter("%@");
        System.out.println(r);
        }

    public static boolean isSpecialCharacter(String enteredCmd) {
        Pattern regex = Pattern.compile("[%@#]");
        Matcher m = regex.matcher(enteredCmd);
        boolean isSpecialChar = m.matches();
        return  isSpecialChar;
    }
}
