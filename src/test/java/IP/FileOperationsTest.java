package test.java.IP;

import main.java.IP.ToDoList.FileOperations;
import main.java.IP.ToDoList.Task;
import main.java.IP.ToDoList.ToDoLy;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileOperationsTest {

    /**
     * This test validates the readData() method from FileOperations class.
     * this test passes when the file is read properly .
     */
    @Test
    public void testReadFromFile() {
        FileOperations fileOp = new FileOperations();
        List<Task> taskdetailsToRead = null;
        int noOfTaskBeforeRead;
        try {
            /** saving the value of the size of the list BEFORE any data is read from the file */
            noOfTaskBeforeRead = taskdetailsToRead.size();
        } catch (NullPointerException e) {
            noOfTaskBeforeRead = 0;
        }
        taskdetailsToRead = new ArrayList<>(fileOp.readData());
        /** saving the value of the size of the list AFTER any data is read from the file */
        int noOfTaskAfterRead = taskdetailsToRead.size();

        assertEquals(0, noOfTaskBeforeRead);
        /** Comparing the size of the list before and after file read method was called */
        assertEquals(true, noOfTaskBeforeRead < noOfTaskAfterRead);

    }

    /**
     * This test validates the writeData method of the FileOperations class.
     * The data is first written to the file, then read from the file and then compared with
     * the test data
     */

    @Test
    public void testWriteToFile() {
        FileOperations fileOp = new FileOperations();
        ToDoLy toDoLy = new ToDoLy();
        List<Task> taskdetailsToWrite = new ArrayList<>();
        List<Task> taskdetailsToRead = null;

        /** Setting up TestData  */
        String ifWriteActual = null;
        Task taskDet;
        int taskID = toDoLy.getMaxTaskID() + 1;
        String taskDetail = "Clean kitchen";
        String date = "2020-02-11";
        String project = "Home";
        taskDet = new Task(taskID, taskDetail, LocalDate.parse(date), project, false);
        System.out.println(taskDet.getTaskId());

        taskdetailsToWrite.add(taskDet);
        /** Validating the writeDate method of FileOperations */
        fileOp.writeData(taskdetailsToWrite);
        taskdetailsToRead = fileOp.readData();
        for (Task rec : taskdetailsToRead) {
            if (rec.getTaskId() == taskID) {
                ifWriteActual = rec.getTaskDetails();
            }
        }
        String ifWriteExpected = taskDet.getTaskDetails();
        assertEquals(ifWriteExpected, ifWriteActual);

    }


}
