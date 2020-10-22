package test.java.IP;

import main.java.IP.ToDoList.ToDoLy;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ToDoLyTest {
    @Test
    public void testeditTask() {
        ToDoLy todoApp = new ToDoLy();
        todoApp.editTask();
        assert(true);
    }

    @Test
    public void addOneTask() {
        ToDoLy todoApp = new ToDoLy();
        int noOftaskBeforeAddMethod = todoApp.getNumberOfTasks();
       // int tid = todoApp.getNumberOfTasks()+1;
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        /*System.setIn(new ByteArrayInputStream(taskDetail.getBytes()));
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        System.setIn(new ByteArrayInputStream(project.getBytes()));*/
        assertEquals(noOftaskBeforeAddMethod+1,todoApp.getNumberOfTasks());

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
        todoApp.addNewTask(taskDetail, LocalDate.parse(date) ,project, false);
        todoApp.removeTask(todoApp.getTaskById(noOftaskBeforeAddMethod));
        /*System.setIn(new ByteArrayInputStream(taskDetail.getBytes()));
        System.setIn(new ByteArrayInputStream(date.getBytes()));
        System.setIn(new ByteArrayInputStream(project.getBytes()));*/
        assertEquals(noOftaskBeforeAddMethod+2,todoApp.getNumberOfTasks());
    }
}
