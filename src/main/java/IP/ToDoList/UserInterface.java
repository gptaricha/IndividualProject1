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
package main.java.IP.ToDoList;

import java.io.PrintStream;
import java.util.List;

public class UserInterface {
    private final List<Task> taskDetails;
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_PURPLE = "\u001B[35m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    private int countOfTasksDone;
    private int countOfPendingTasks;

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

        System.out.print(ANSI_BLUE + ">>" + ANSI_RESET + " Welcome to ToDoLy \n" + ANSI_RESET);
    }

    /**
     * Displays the list of valid options that user can choose from
     * for different activities in the application
     */
    public void printPickOptions(){
        countOfTasksDone=0;
        countOfPendingTasks=0;
        for(Task record: taskDetails) {
            // updates the no of completed and pending tasks
            if (record.getStatus()) {
                countOfTasksDone++;
            } else if (!record.getStatus()) {
                countOfPendingTasks++;
            }
        }
        System.out.println(ANSI_BLUE + ">>" + ANSI_RESET + " You have " + countOfPendingTasks + " tasks todo and " + countOfTasksDone + " tasks done");
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

    public void printCompletedTaskDetails(List<Task> taskdetails) {
        System.out.println(ANSI_GREEN+"************************* Completed Tasks  ************************"+ANSI_RESET);
        System.out.println("+--------+-----------------------------+------------+-------------+");
        System.out.printf(ANSI_PURPLE+"| %-7s| %-28s| %-11s| %-16s|\n",  "TaskID", "Task Title" ,"DueDate", "Project"+ANSI_RESET);
        System.out.println("+--------+-----------------------------+------------+-------------+");

     for (Task element : taskdetails) {
         if ( element.getStatus() == true) {
             PrintStream printf = System.out.printf(ANSI_BLUE + "| %-7s| %-28s| %-11s| %-16s|\n",
                     element.getTaskId()
                     , element.getTaskDesc()
                     , element.getDueDate()
                     , element.getProject()
                             + ANSI_RESET);
         }
       }
     System.out.println("+--------+-----------------------------+------------+-------------+");
        System.out.println();
    }

    public void printPendingTaskDetails(List<Task> taskdetails) {
        System.out.println(ANSI_GREEN+"************************* Show Pending Tasks ************************"+ANSI_RESET);
        System.out.println("+--------+-----------------------------+------------+-------------+");
        System.out.printf(ANSI_PURPLE+"| %-7s| %-28s| %-11s| %-16s|\n",  "TaskID", "Task Title" ,"DueDate", "Project"+ANSI_RESET);
        System.out.println("+--------+-----------------------------+------------+-------------+");

        for (Task element : taskdetails) {
            if ( element.getStatus() == false) {
                PrintStream printf = System.out.printf("|"+ANSI_BLUE +" %-7s| %-28s| %-11s| %-16s|\n",
                        element.getTaskId()
                        , element.getTaskDesc()
                        , element.getDueDate()
                        , element.getProject()
                                + ANSI_RESET);
            }

        }
        System.out.println("+--------+-----------------------------+------------+-------------+");
        System.out.println();
    }
    /**
     * Displays the available choices to the user on selecting Edit task option from the Pick up list in To Do application
     */
    public void printEditTaskOption(){
        System.out.println("Please select what would you like to do from the below choices: ");
        System.out.println(" (a) Update Task \n"+
                           " (b) Mark Status as Done \n"+
                           " (c) Remove task");
    }

    /**
     * Displays invalid user Command in RED, when the user input does not match the valid options displayed on the console
     *
     */
    public void printInvalidMessg() {
        System.out.println(ANSI_RED+"Invalid user command!! \n Please try again"+ANSI_RESET);
    }

}
