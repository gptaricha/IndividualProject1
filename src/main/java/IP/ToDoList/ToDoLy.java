/**
 * This class is the main class of the "main.java.IP.ToDoList" application.
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
package main.java.IP.ToDoList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static main.java.IP.ToDoList.UserInterface.*;

public class ToDoLy {
    private final InputReader read;
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

    }

    /**
     * Calls the method in the userInterface to print the welcome message in the user console.
     * Calls the method in the userInterface which gives choice to the user to enter a choice from the printed list.
     * Calls the method to read and process the input by the user
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
     *
     * @param userInput as entered by the user
     */
    public void processUserCommand(String userInput) {
        if (userInput.equals("1"))
            showTaskList();

        else if (userInput.equals("2"))
            addTaskPrompt();

        else if (userInput.equals("3"))
            editTask();

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
        userInterface.printPendingTaskDetails(taskdetails);
        userInterface.printCompletedTaskDetails(taskdetails);

        String userSortOption;
        while (true) {
            System.out.println("Do you want to sort the list by Date(D) or Project(P) or hit ENTER to go to main Menu? ");
            userSortOption = read.getCommand().trim().toLowerCase();
            if (userSortOption.isEmpty()) {
                break;
            } else {
                sortTaskBy(userSortOption);
            }
        }
    }

    /**
     * Sorts all the Tasks by either Project or Date depending on user input
     *
     * @param projectOrDate as entered by the user
     */
    public void sortTaskBy(String projectOrDate) {
        if (projectOrDate.equalsIgnoreCase("P")) {
            Collections.sort(taskdetails, Task.ProjectComparator);
            userInterface.printPendingTaskDetails(taskdetails);
        } else if (projectOrDate.equalsIgnoreCase("D")) {
            Collections.sort(taskdetails, Task.DateComparator);
            userInterface.printPendingTaskDetails(taskdetails);
        } else
            userInterface.printInvalidMessg();
    }

    /**
     * Provides an option to the user to create a new task using the application.
     * It will prompt the user to add task title, due date and project to which the new task would belong to
     */
    public void addTaskPrompt() {
        String taskDetail = read.getValidCommand("Enter the task Title: ");
        LocalDate dueDate = read.getValidDateFormat("Enter the Due Date: ");
        String project = read.getValidCommand("Enter Project to which the task belong to: ");

        addNewTask(taskDetail, dueDate, project, false);
        System.out.println("Thank you! Task added!");
    }

    /**
     * It can add the task details finally to the Task.
     */
    public void addNewTask(String taskDetail, LocalDate dueDate, String project, boolean status) {
        /*int maxsofar = 0;
        for (Task t : taskdetails) {
            int id = t.getTaskId();
            if (id > maxsofar)
                maxsofar = id;
        }*/
        int taskID = getMaxTaskID() +1;
        Task t = new Task(taskID, taskDetail, dueDate, project, status);
        taskdetails.add(t);
    }
/**
 *
 */
public int getMaxTaskID() {
    int maxsofar = 0;
    for (Task t : taskdetails) {
        int id = t.getTaskId();
        if (id > maxsofar)
            maxsofar = id;
    } return  maxsofar;

}
    /**
     * It can edit the task, mark the task as done or remove the task
     */
    public void editTask() {
        try {
           int taskToEdit = read.getValidIntCmd("Enter the task Id you want to update?");
            Task selectedTask = getTaskById(taskToEdit);
            if(selectedTask !=null){
            userInterface.printEditTaskOption();

            String editCommand = read.getCommand();

            if (editCommand.equalsIgnoreCase("a")) {
                updateTask(selectedTask);
            } else if (editCommand.equalsIgnoreCase("b")) {
                setTaskStatus(selectedTask);
            } else if (editCommand.equalsIgnoreCase("c")) {
                removeTask(selectedTask);
            } else {
                userInterface.printInvalidMessg();
            } } else {System.out.println(ANSI_RED + "Task does not exists! Redirecting back to the Main Menu" + ANSI_RESET);}
        } catch (NullPointerException e) {
            System.out.println(ANSI_RED + "Task does not exists! Redirecting back to the Main Menu" + ANSI_RESET);
        }
    }

    /**
     * This method returns task details based on taskID
     * @param taskID entered by the user
     * @return taskdetails
     */
    public Task getTaskById(int taskID) {
        for (Task element : taskdetails) {
            if (taskID == element.getTaskId()) {return element;}
        }
        return null;
    }

    /**
     * Updates the task and saves it to the task list
     */
    public void updateTask(Task selectedTask) {
        System.out.printf("Enter new Task title to edit or hit Enter to keep title: " + ANSI_BLUE + "%s " + ANSI_RESET, selectedTask.getTaskDesc());
        String newTaskTitle = read.getCommand(null);
        if(read.isSpecialCharacter(newTaskTitle)) { newTaskTitle = read.getValidCommand(newTaskTitle);}

        if (!newTaskTitle.isEmpty()) {
            selectedTask.setTaskDesc(newTaskTitle);
        }

        System.out.printf("Enter new Due date or hit Enter to keep the Due Date: " + ANSI_BLUE + "%tF " + ANSI_RESET, selectedTask.getDueDate());
        String newDateInString = read.getCommand();
        if (!newDateInString.isEmpty()) {
            LocalDate newDueDate = read.getValidDateFormat(newDateInString);
            selectedTask.setDueDate(newDueDate);
        }

        System.out.printf("Enter new project or hit Enter to keep the project: " + ANSI_BLUE + "%s" + ANSI_RESET, selectedTask.getProject());
        String newProject = read.getCommand();
        if (!newProject.isEmpty()) {
            selectedTask.setProject(newProject);
        }

        System.out.println(ANSI_GREEN + "Task successfully updated" + ANSI_RESET);
    }

    /**
     * Sets the status of the task as done
     */
    public void setTaskStatus(Task selectedTask) {
        selectedTask.setStatus(true);
        System.out.println(ANSI_GREEN + "Successfully marked as Done" + ANSI_RESET);
    }

    /**
     * Remove the existing task from the list
     */
    public void removeTask(Task specificTask) {
        taskdetails.remove(specificTask);
        System.out.println(ANSI_GREEN + "Task deleted successfully!" + ANSI_RESET);
    }

    /**
     * It will save the task to the file and quit the application
     */
    public void saveQuit() {
        System.out.println(ANSI_GREEN + "Saving file..." + ANSI_RESET);
        fileData.writeData(taskdetails);
        System.exit(0);
    }

    /**
     * Returns the size of the task object
     * @return taskdetails.size()
     */
    public int getNumberOfTasks() {
        return taskdetails.size();
    }
}
