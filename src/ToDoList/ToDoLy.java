/**
 * This class is the main class of the "ToDoList" application.
 * "ToDoLy" allows the user to create new tasks, assign them a title and due date, and choose a project for that
 * task to belong to.
 * They can also quit and save the current task list to file, and then
 * restart the application with the former state restored.
 * <p>
 * To be able to use the application, go to the Menu class and run the method main().
 * <p>
 * This ToDoLy class creates and initialises all the others: it creates all
 * task, inputReader, File and starts the application with a welcome message
 * It allows the user to select what they want to do in this application(like, view, Add a new task, edit/remove or quit)
 * and evaluates the respective task
 *
 * @author Richa Gupta
 * @version 2020.10.09
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ToDoLy {
    private final InputReader read;
    private final DateFormat formatter;
    List<Task> taskdetails;
    FileOperations fileData;
    UserInterface userInterface;
    Task task;

    /**
     * Create the ToDoLy(To-Do list) application instance.
     */
    public ToDoLy() {
        task = new Task();
        read = new InputReader();
        fileData = new FileOperations();
        taskdetails = new ArrayList<>(fileData.readData());
        userInterface = new UserInterface(taskdetails);
        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
    }

    /**
     *
     * Calls the method in the userInterface to print the welcome message in the user console.
     * Calls the method in the userInterface which gives choice to the user to enter a choice from the printed list.
     * Calls the method to read and process the input by the user
     *
     */
    public void startToDoLy() {
        userInterface.printWelcomeMessage();
        userInterface.printPickOptions();
        while (true) {
            String userInput = read.getCommand();
            processUserCommand(userInput);
            userInterface.printPickOptions();
        }

    }

    /**
     * This method evaluates the user input and calls the methods linked to the user inputs.
     * @param userInput
     */
    public void processUserCommand(String userInput) {
        if (userInput.equals("1"))
            showTaskList();
        else if (userInput.equals("2"))
            addTask();
        else if (userInput.equals("3"))
            System.out.println("In Progress");
        else if (userInput.equals("4"))
            saveQuit();
        else
            userInterface.printInvalidMessg();
    }

    /**
     * This method displays the details of all the task in the toDoLy application.
     * Gives option to the user to either sort the list or return to the main Menu screen
     */
    public void showTaskList() {
        userInterface.printTaskDetails(taskdetails);
        String userSortOption;
        while (true) {
            System.out.println("Do you want to sort the list by Date(D) or Project(P) or Back to main Menu(Back)? ");
            userSortOption = read.getCommand().trim().toLowerCase();
            if (userSortOption.startsWith("back")) {
                break;
            } else {
                sortTaskBy(userSortOption);
            }
        }
    }

    /**
     * Sorts all the Tasks by either Project or Date depending on user input
     * @param projectOrDate
     */
    public void sortTaskBy(String projectOrDate) {
        if (projectOrDate.equalsIgnoreCase("P")) {
            Collections.sort(taskdetails, Task.ProjectComparator);
            userInterface.printTaskDetails(taskdetails);
        } else if (projectOrDate.equalsIgnoreCase("D")) {
            Collections.sort(taskdetails, Task.DateComparator);
            userInterface.printTaskDetails(taskdetails);
        } else
            userInterface.printInvalidMessg();
    }

    /**
     * Provides an option to the user to create a new task using the application.
     * It will prompt the user to add task title, due date and project to which the new task would belong to
     */
    public void addTask() {
        try {
            System.out.println("Enter the task ID: ");
            int taskID = Integer.parseInt(read.getCommand());
            System.out.println("Enter the task Title: ");
            String taskDetail = read.getCommand();
            System.out.println("Enter the Due Date: ");
            Date dueDate = formatter.parse(read.getCommand());
            System.out.println("Enter Project to which the task belong to: ");
            String project = read.getCommand();
            Task t = new Task(taskID, taskDetail, dueDate, project);
            taskdetails.add(t);
            System.out.println("Thank you! Task added!");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * It will save the task to the file and quit the application
     */
    public void saveQuit() {
        System.out.println("Saving file...");
        fileData.writeData(taskdetails);
        System.exit(0);
    }
}
