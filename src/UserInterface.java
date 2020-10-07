import java.util.List;

public class UserInterface {
    private int numOfTaskToDo;
    private int numOfTaskDone;
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    public void printWelcomeMessage() {
        System.out.println(ANSI_BLUE + ">>" + ANSI_RESET + " Welcome to ToDoLy \n" + ANSI_RESET +
                ANSI_BLUE + ">>" + ANSI_RESET + " You have " + numOfTaskToDo + " tasks todo and " + numOfTaskDone + " tasks done \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " Pick an option: \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 1 + ANSI_RESET + ") Show Task List (by date or project) \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 2 + ANSI_RESET + ") Add New Task \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 3 + ANSI_RESET + ") Edit Task (update, mark as done, remove \n" +
                ANSI_BLUE + ">>" + ANSI_RESET + " (" + ANSI_PURPLE + 4 + ANSI_RESET + ") Save and Quit" + ANSI_RESET);
 }

    public void printTaskDetails(List<Task> taskdetails) {
        System.out.println("	************* Show Tasks **************** \n" +
                "TaskID	, Task Details , DueDate, Project ");
        System.out.println("--------------------------------------------");
     for (Task element : taskdetails) {
        System.out.println(element.getTaskDetails());
     }
        System.out.println("Do you want to sort the list by Date(D) or Project(P)? ");

    }
}
