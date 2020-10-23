package test.java.IP;

import main.java.IP.ToDoList.Task;
import main.java.IP.ToDoList.ToDoLy;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ToDoLyTest {
    /**
     * Test to check if the addNewTask() method of Todoly class correctly adds the task.
     */
    @Test
    public void addOneTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOfTaskBeforeAdd = todoApp.getNumberOfTasks();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        assertEquals(noOfTaskBeforeAdd+1,todoApp.getNumberOfTasks());
    }

    /**
     * Adding two task to the list and checking if the number of tasks inceremented correctly
     * by invoking getNumberOfTasks() method of ToDoly class
     */
    @Test
    public void addMultipleTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        assertEquals(noOftaskBeforeAddMethod+2,todoApp.getNumberOfTasks());
    }
    /**
     * Testing the removeTask functionality.
     * Adding two task to the list, then calling removeTask() method and then checking if the number of tasks got
     * decremented correctly by invoking getNumberOfTasks() method of ToDoly class
     *
     */
    @Test
    public void removeOneTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        //Task1
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        //Task2
        String taskDetail2 = "Buy groceries";
        String date2 = "2020-02-11";
        String project2 = "Home";
        //Add Tasks
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        todoApp.addNewTask(taskDetail2, LocalDate.parse(date2) ,project2, false);
        //Remove task
        todoApp.removeTask(todoApp.getTaskById(noOftaskBeforeAddMethod+1));
        //Test
        assertEquals(noOftaskBeforeAddMethod+1,todoApp.getNumberOfTasks());
    }

    /**
     * This test will validate the setTaskStatus(Task selectedTask) method in the the TodoLy class.
     * On calling setTaskStatus(Task selectedTask) method, the status of the selected task gets
     * updated to true threby, putting it in the list of completed tasks
     */
    @Test
    public void changeTaskStatusToDone() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        //Task1
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        //Task2
        String taskDetail2 = "Buy groceries";
        String date2 = "2020-02-11";
        String project2 = "Home";
        //Add Tasks
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        todoApp.addNewTask(taskDetail2, LocalDate.parse(date2) ,project2, false);

        Task gettask1 = todoApp.getTaskById(noOftaskBeforeAddMethod + 1);
        //Setting task1 to completed
        todoApp.setTaskStatus(gettask1);
        // asserting for the task whose status got set to completed
        assertEquals(true, gettask1.getStatus());

        Task gettask2 = todoApp.getTaskById(noOftaskBeforeAddMethod + 2);
        // asserting for the task whose status is still pending
        assertEquals(false, gettask2.getStatus());
    }

    /**
     * This will check if the method getMaxTaskID() from the ToDoLy class, is returning the correct value
     */

    @Test
    public void testgetMaxTaskID() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getMaxTaskID();
        //Task1
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Kitchen";

        //Add Tasks
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        //get new maximum taskID
        int newMaxofTaskID = todoApp.getMaxTaskID();
        assertEquals(noOftaskBeforeAddMethod+1, newMaxofTaskID);
    }


    @Test
    public void updateTaskById() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getMaxTaskID();
        //Task1
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Kitchen";

        //Add Tasks
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);

        Task taskReturned = todoApp.getTaskById(noOftaskBeforeAddMethod + 1);

        taskReturned.toString();
        assertEquals(project, todoApp.getTaskById(noOftaskBeforeAddMethod+1).getProject());
    }

}
