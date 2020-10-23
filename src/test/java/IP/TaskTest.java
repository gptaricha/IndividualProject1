package test.java.IP;
import main.java.IP.ToDoList.Task;
import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class TaskTest {
    /**
     * Test to check if the getTaskID method of Task class returns correct value
     */
    @Test
    public void checkTaskId() {
        Task task = new Task();
        int tid = task.getTaskId();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid, taskDetail, LocalDate.parse(date), project, false);
        int expected = task.getTaskId();
        assertEquals(1, expected);
    }

    /**
     * Test to check if the getTaskDesc method of Task class returns correct value after task is created
     */
    @Test
    public void addTaskDesc() {
        Task task = new Task();
        int tid = task.getTaskId();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid, taskDetail, LocalDate.parse(date), project, false);
        assertEquals(taskDetail, task.getTaskDesc());
    }

    /**
     * Test to check if the getDueDate method of Task class returns correct value after task is created
     */
    @Test
    public void addTaskDate() {
        Task task = new Task();
        int tid = task.getTaskId();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid, taskDetail, LocalDate.parse(date), project, false);
        assertEquals(LocalDate.parse(date), task.getDueDate());
    }

    /**
     * It tests the method getTaskDetails() of the Task class which gives the taskdetails
     */
    @Test
    public void testgetTaskDetails() {
        Task task = new Task();
        int tid = task.getTaskId() + 1;
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid, taskDetail, LocalDate.parse(date), project, false);
        String expected = " TaskID : 2, Task Title: Clean kitchen, Due Date: 2020-02-11, Project: Home";
        assertEquals(expected, task.getTaskDetails());
    }
}
