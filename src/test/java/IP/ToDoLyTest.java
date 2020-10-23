package test.java.IP;

import main.java.IP.ToDoList.Task;
import main.java.IP.ToDoList.ToDoLy;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ToDoLyTest {
   /* @Test
    public void testeditTask() {
        ToDoLy todoApp = new ToDoLy();
        todoApp.editTask();
        assert(true);
    } */

    @Test
    public void addOneTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOfTaskBeforeAdd = todoApp.getNumberOfTasks();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        /*System.setIn(new ByteArrayInputStream(taskDetail.getBytes()));
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        System.setIn(new ByteArrayInputStream(project.getBytes()));*/
        assertEquals(noOfTaskBeforeAdd+1,todoApp.getNumberOfTasks());

    }
    @Test
    public void addMultipleTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        // int tid = todoApp.getNumberOfTasks()+1;
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        /*System.setIn(new ByteArrayInputStream(taskDetail.getBytes()));
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        System.setIn(new ByteArrayInputStream(project.getBytes()));*/
        assertEquals(noOftaskBeforeAddMethod+2,todoApp.getNumberOfTasks());
    }

    @Test
    public void removeOneTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        // int tid = todoApp.getNumberOfTasks()+1;
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";

        String taskDetail2 = "Buy groceries";
        String date2 = "2020-02-11";
        String project2 = "Home";

        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        todoApp.addNewTask(taskDetail2, LocalDate.parse(date2) ,project2, false);

        todoApp.removeTask(todoApp.getTaskById(noOftaskBeforeAddMethod+1));

        /*System.setIn(new ByteArrayInputStream(taskDetail.getBytes()));
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        System.setIn(new ByteArrayInputStream(project.getBytes()));*/
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
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";

        String taskDetail2 = "Buy groceries";
        String date2 = "2020-02-11";
        String project2 = "Home";


        todoApp.addNewTask(taskDetail, LocalDate.parse(date), project, false);
        todoApp.addNewTask(taskDetail2, LocalDate.parse(date2), project2, false);
        Task gettask1 = todoApp.getTaskById(noOftaskBeforeAddMethod + 1);
        todoApp.setTaskStatus(gettask1);
        assertEquals(true, gettask1.getStatus());

        Task gettask2 = todoApp.getTaskById(noOftaskBeforeAddMethod + 2);
        //todoApp.setTaskStatus(gettask2);
        assertEquals(false, gettask2.getStatus());
    }
    @Test
    public void updateTaskById() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";

        String taskDetail2 = "Buy groceries";
        String date2 = "2020-02-11";
        String project2 = "Shop";

        todoApp.addNewTask(taskDetail, LocalDate.parse(date), project, false);

        Task taskReturned = todoApp.getTaskById(noOftaskBeforeAddMethod + 1);

        todoApp.updateTask(taskReturned);
        //System.setIn(new ByteArrayInputStream(taskDetail.getBytes()));
        //System.setIn(new ByteArrayInputStream(date.getBytes()));
        //System.setIn(new ByteArrayInputStream(project2.getBytes()));

        taskReturned.toString();
        assertEquals(project2, todoApp.getTaskById(noOftaskBeforeAddMethod+1).getProject());



    }


    @Test
    public void testgetElementValueByIndex() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";

        String taskDetail2 = "Buy groceries";
        String date2 = "2020-02-11";
        String project2 = "Shop";

       // todoApp.addNewTask(taskDetail, LocalDate.parse(date), project, false);
        int expected = 4;
    }
}
