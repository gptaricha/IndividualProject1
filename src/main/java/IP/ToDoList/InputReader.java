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
     * @return
     */
    public String getCommand() {
        System.out.print(">> ");     // print prompt
        return reader.nextLine().trim().toLowerCase();
    }
    // Match for if the entered user input contains special characters
    public boolean isSpecialCharacter(String taskToEditInString) {

        Pattern regex = Pattern.compile("[$&£+,:;=?@#|'<>.-^*()%!]");
        Matcher m = regex.matcher(taskToEditInString);
        boolean isSpecialChar = m.matches();
        System.out.println("inside isspecial: "+taskToEditInString);
        System.out.println("value of bool: "+isSpecialChar);
        return  isSpecialChar;
    }
    public String getValidCommand() {
        String enteredCmd;
        do {
            System.out.println(ANSI_RED+"Not a valid input. Please enter again"+ANSI_RESET);
            enteredCmd = getCommand();
        }
        while (enteredCmd.isEmpty()||isSpecialCharacter(enteredCmd));
        System.out.println("TESTT");
        return enteredCmd;
    }

    public LocalDate getValidDateFormat(String defaultDate) {
        if (isValidDate(defaultDate))
            return LocalDate.parse(defaultDate);

        String sDate = null;
        do {
            System.out.println(ANSI_RED+"Invalid date. Enter ISO format"+ANSI_RESET);
            sDate = getCommand();
        }
        while (!isValidDate(sDate));

        return LocalDate.parse(sDate);
    }

    public boolean isValidDate(String s) {
        try {
            LocalDate.parse(s);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
