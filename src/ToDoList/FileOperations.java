/**
 * This class is part of the "To Do List" application.
 * "To Do List" is a text based application to create new tasks, assign them a title  due date and group it under a project.
 *
 * This class is responsible for all the operations related to File handling operations
 *
 * This class will be called internally from ToDOLy class when the user starts the application.
 *
 * @author Richa Gupta
 * @version 2020.10.09
 */

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    private final String path = "/Users/richagupta/IndividualProject1/src/";

    /**
     * Reading from a file & creating task objects for each record from the file
     * @return ArrayList<Task>
     */
    public ArrayList<Task> readData() {
        /* An arrayList of Task type to store all the details from the input file */
       ArrayList<Task> taskLists = new ArrayList<>();
        try {
            /* Attach a file to the Bufferred Reader */
            BufferedReader br = new BufferedReader(new FileReader(new File(path, "TaskList.txt")));
            String line = "";
            //Reads all the lines of the text from the buffered reader until the end of file
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");   //Splitting each lines into multiple fields based on separator ';'
                Task readTask = fileToTask(fields);
                taskLists.add(readTask);
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException p) {

        }
        return taskLists;
    }

    /**
     * Formats the object of Task type to String data type
     * @param writeTask
     * @return
     */
    private String taskToFile(Task writeTask) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); // format the Date
        return writeTask.getTaskId() + ";" + writeTask.getTaskDesc() + ";" + formatter.format(writeTask.getDueDate()) + ";" + writeTask.getProject();
    }

    /**
     * Creates an object of type Task from the input param which is the data read from the file
     * returns the task details of Task type
     * @param  fields
     * @return readTask
     * @throws ParseException
     */
    private Task fileToTask(String[] fields) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Task readTask = new Task(Integer.parseInt(fields[0]) //TaskID
                , fields[1] // TaskDetails
                , format.parse(fields[2]) //DueDate , formatting string to Date data type
                , fields[3] //Project
                //,fields[4] //Status  to be Implemented
        );

        return readTask;
    }

    /**
     * Writes all the task objects into a local file and save it
     * @param list
     */
    public void writeData(List<Task> list) {
        try {
            //Attach a file to the file writer.Attach a file writer to a bufferred writer
            BufferedWriter bw = new BufferedWriter(new FileWriter(path + "TaskList.txt", false));
            // Writes each of the Task object into a local file
            for (Task eachTask : list) {
                bw.write(taskToFile(eachTask) + "\n"); //method call to convert the Task data type to String
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File doesn't found " + e);
        }
    }

}
