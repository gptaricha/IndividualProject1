package test.java.IP;

import main.java.IP.ToDoList.Task;
import main.java.IP.ToDoList.ToDoLy;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class TaskTest {

    @Test
    public void checkTaskId() {
        Task task = null;
        int tid = task.getTaskId();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid,taskDetail,LocalDate.parse(date),project,false);
        int expected = task.getTaskId();
        assertEquals(1,expected);
       }
    @Test
    public void addTaskDesc() {
        Task task = null;
        int tid = task.getTaskId();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid,taskDetail,LocalDate.parse(date),project,false);
        assertEquals(taskDetail,task.getTaskDesc());
    }
    @Test
    public void addTaskDate() {
        Task task = null;
        int tid = task.getTaskId();
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        task = new Task(tid,taskDetail,LocalDate.parse(date),project,false);
        assertEquals(LocalDate.parse(date),task.getDueDate());
       // assertEquals("Check if date entered is valid",LocalDate.parse(date),task.getDueDate());
    }
    @Test
    public void addTwoElements() {

        String expected = "LinkedList(5,2)";
        //assertEquals(expected, list.toString());
    }

    @Test
    public void searchElement() {

        int expected = 8;
      //  assertEquals(expected, list.getIndex(3));
    }

    @Test
    public void getElementValueByIndex() {
      /*  LinkedList list = new LinkedList();
        list.add(4);
        list.add(9);
        list.add(4);
        int expected = 4;
        assertEquals(expected, list.getElementbyIndex(8));*/
    }


}
