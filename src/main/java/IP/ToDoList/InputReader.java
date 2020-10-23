/**
 * This class is part of the "To Do List" application.
 * "To Do List" is a text based application to create new tasks, assign them a title  due date and group it under a project.
 * <p>
 * This InputReader class reads user input and tries to interpret it as an "Activity"
 * that user wish to perform. Every time it is called it reads a line from the terminal and
 * tries to interpret the line. It returns the command
 * as String object
 * <p>
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author Richa Gupta
 * @version 2020.10.09
 */
package main.java.IP.ToDoList;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputReader {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private final Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     */
    public InputReader() {
        reader = new Scanner(System.in);
    }

    /**
     * Returns commands from user
     *
     * @return user commands in string
     */
    public String getCommand(){
        return getCommand(null);
    }
    public String getCommand(String msg){
        if(msg != null)
            System.out.print(">> " + msg+" >> ");
        else
            System.out.print(">> ");     // print prompt
        return reader.nextLine().trim().toLowerCase();
    }
    /**
     * Match for if the entered user input contains special characters
     */

    public boolean isSpecialCharacter(String enteredCmd) {
        Pattern regex = Pattern.compile("[%@#€]+");
        Matcher m = regex.matcher(enteredCmd);
        return  m.matches();
    }
    /**
     * Checks whether a String is numeric or not
     */
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    /**
     * Prompts the user to enter the input until the input is not empty and does not have special characters type
     * @param msg
     * @return a valid string
     */
    public String getValidCommand(String msg) {
        String enteredCmd = getCommand(msg);
        while (enteredCmd.isEmpty()||isSpecialCharacter(enteredCmd)) {
            enteredCmd = getCommand(ANSI_RED+"Not a valid input. Please enter again"+ANSI_RESET);
        }
        return enteredCmd;
    }
    /**
     * Prompts the user to enter the input until the input is of integer type
     * @param msg
     * @return value in integer type
     */

    public int getValidIntCmd(String msg) {
        String readInt = getCommand(msg);
        while (!isNumeric(readInt))    {
            readInt = getCommand(ANSI_RED+"Not a valid input. Please enter again"+ANSI_RESET);
        }

        return Integer.parseInt(readInt);
    }

    /**
     * Prompts the user to enter the date until the date is in valid format which is "YYYY-MM-DD"
     * @param msg
     * @return date in valid format
     */

    public LocalDate getValidDateFormat(String msg) {
        String sDate = getCommand(msg);

        while (!isValidDate(sDate)){
            sDate = getCommand(ANSI_RED+"Invalid date. Enter ISO format"+ANSI_RESET);
        }
        return LocalDate.parse(sDate);
    }

    /**
     * Returns true if the date is in valid ISO format "YYYY-MM-DD"
     * @param s
     * @return
     */

    public boolean isValidDate(String s) {
        try {
            LocalDate.parse(s);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
