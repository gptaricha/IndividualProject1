import javax.imageio.IIOException;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileOperations {
    private String path = "/Users/richagupta/IndividualProject1/src/";

    public ArrayList<Task> readData() {
        Scanner fileReader = null;
        String data = "";
        ArrayList<Task> taskLists = new ArrayList<>();
        DateFormat format = new SimpleDateFormat("DD-MM-YYYY", Locale.ENGLISH );
        try {
            FileReader file = new FileReader(path + "TaskList.txt");
        //     fileReader = new Scanner(file);
            BufferedReader bufferFileReader= new BufferedReader(file);
            String line ="";
            while ((line = bufferFileReader.readLine())!= null) {
                String fields [] = line.split(";");
                Task readTask = new Task(Integer.parseInt(fields[0]) //TaskID
                                 ,fields[1] // TaskDetails
                                 , format.parse(fields[2]) //DueDate
                                 , fields[3] //Project
                                 //,fields[4] //Status
                         );
                taskLists.add(readTask);
             }
            bufferFileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return taskLists;
    }
}
