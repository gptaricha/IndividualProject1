/**
 * This class is part of the "To Do List" application.
 * "To Do List" is a text based application to create new tasks, assign them a title  due date and group it under a project.
 *
 * This class provides the User Interface experience to the user.
 * It handles what a user can see in the console. It mainly focusses on the design and layout of the application
 *
 * @author Richa Gupta
 * @version 2020.10.09
 */

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private List<Task> taskDetails;
    private int numOfTaskDone;
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    /**
     * Constructor to initialize the numOfTaskToDo which is holding the count of all the tasks to be done
     *
     */
    public UserInterface(List<Task> taskDetails) {
        this.taskDetails = taskDetails;
    }

    /**
     * Prints the Welcome message on the user console when the user starts the application
     * Gets called only once
     */
    public void printWelcomeMessage() {

        System.out.println(ANSI_BLUE + ">>" + ANSI_RESET + " Welcome to ToDoLy \n" + ANSI_RESET +
                ANSI_BLUE + ">>" + ANSI_RESET + " You have " + taskDetails.size() + " tasks todo and " + numOfTaskDone + " tasks done") ;

    }

    /**
     * Displays the list of valid options that user can choose from
     * for different activities in the application
     */
    public void printPickOptions(){
        System.out.println(ANSI_BLUE + ">>" + ANSI_RESET + " Pick an option: \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 1 + ANSI_RESET + ") Show Task List (by date or project) \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 2 + ANSI_RESET + ") Add New Task \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 3 + ANSI_RESET + ") Edit Task (update, mark as done, remove) \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 4 + ANSI_RESET + ") Save and Quit" + ANSI_RESET);
    }

    /**
     * Displays the entire To Do lists with title, dueDate, project
     * @param taskdetails
     */

    public void printTaskDetails(List<Task> taskdetails) {
        System.out.println(ANSI_GREEN+"************************* Show Tasks ************************"+ANSI_RESET);
        System.out.println("+--------+-----------------------------+------------+-------------+");
        System.out.printf(ANSI_PURPLE+"| %-7s| %-28s| %-11s| %-16s|\n",  "TaskID", "Task Title" ,"DueDate", "Project"+ANSI_RESET);
        System.out.println("+--------+-----------------------------+------------+-------------+");
     for (Task element : taskdetails) {
         PrintStream printf = System.out.printf(ANSI_BLUE + "| %-7s| %-28s| %-11s| %-16s|\n",
                 element.getTaskId()
                 , element.getTaskDesc()
                 , element.getFormatDueDate()
                 , element.getProject()
                         + ANSI_RESET);

     }
     System.out.println("+--------+-----------------------------+------------+-------------+");
        System.out.println();
    }

    /**
     * Displays invalid user Command in RED, when the user input does not match the valid options displayed on the console
     *
     */
    public void printInvalidMessg() {
        System.out.println(ANSI_RED+"Invalid user command!! \n Please try again"+ANSI_RESET);
    }

}
