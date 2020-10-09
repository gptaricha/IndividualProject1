import java.util.Scanner;

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
public class InputReader {
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
}
