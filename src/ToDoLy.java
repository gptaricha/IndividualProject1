import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoLy {
    List<Task> taskdetails;
    FileOperations fetchData;
    UserInterface userConsole;
    Task task;
    private final InputReader read;

    public ToDoLy() {
        task = new Task();
        read = new InputReader();
        fetchData = new FileOperations();
        taskdetails = new ArrayList<Task>(fetchData.readData());
        userConsole = new UserInterface();
    }

    public void startToDoLy() {
        userConsole.printWelcomeMessage();
        readInput();
    }

    public void readInput() {
        boolean isValid;
        String userInput;
        do {
            userInput = read.getCommand();
            isValid = read.isValidCommand(userInput);
            if (!isValid) {
                System.out.println("Invalid option!! Please select again");
            }
        } while (!isValid);
        processUserInput(userInput);
    }

    public void processUserInput(String userInput) {
        if (userInput.equals("1")) {
            System.out.println("1 selected");
            showTaskList();
            String userSortOption = read.getCommand();
            sortTaskBy(userSortOption);
        }
        if (userInput.equals("2")) {
            task.createTask();
        }
    }

    public void showTaskList() {
        userConsole.printTaskDetails(taskdetails);
    }

    public void sortTaskBy(String projectOrDate) {
        if (projectOrDate.equalsIgnoreCase("P")) {
            Collections.sort(taskdetails, Task.ProjectComparator);
        } else if (projectOrDate.equalsIgnoreCase("D")) {
            Collections.sort(taskdetails, Task.DateComparator);
        }
        userConsole.printTaskDetails(taskdetails);
    }

}
