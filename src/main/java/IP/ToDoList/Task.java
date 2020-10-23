/**
 * This class is part of the "To Do List" application.
 * "To Do List" is a text based application to create new tasks, assign them a title  due date and group it under a project.
 *
 *
 * A task comprises of the taskID, title, due date and project to which it belongs to
 * For each record read from an input file or to be written to a file ,
 * a Task is created having given attributes
 *
 * @author  Richa Gupta
 * @version 2020.10.09
 *
 */
package main.java.IP.ToDoList;
import java.time.LocalDate;
import java.util.Comparator;

public class Task  implements Comparable<Task> {
    public static Comparator<Task> ProjectComparator = new Comparator<Task>() {
        @Override
        public int compare(Task firstProject, Task secondProject) {
            String project1 = firstProject.getProject().toLowerCase();
            String project2 = secondProject.getProject().toLowerCase();
            return project1.compareTo(project2);
        }
    };
    public static Comparator<Task> DateComparator = new Comparator<Task>() {
        @Override
        public int compare(Task firstDate, Task secondDate) {
            LocalDate date1 = firstDate.getDueDate();
            LocalDate date2 = secondDate.getDueDate();
            return date1.compareTo(date2);
        }
    };
    private int taskId =0;
    private String taskDesc;
    private LocalDate dueDate;
    private String project;
    private boolean status;
    private int taskLength;


     public Task( int taskId,String desc, LocalDate date, String projectId,boolean status) {
        this.taskId = taskId;
        this.taskDesc = desc;
        this.dueDate = date;
        this.project = projectId;
        this.status = status;
         taskLength ++;
       // updateNoOfTasksDone(); // updates the no of completed and pending tasks
    }
    public Task() {
    }

    /**
     * It will update the count of no of tasks done
     */


    public void setTaskDesc(String title){
         this.taskDesc= title;
    }
    public void setDueDate(LocalDate dueDate) {
         this.dueDate= dueDate;
    }
    public void setProject(String projectID) {
         this.project = projectID;
    }
    public void setStatus(boolean status) {
         this.status= status;
    }
    public int getTaskId() {
        if(taskId ==0) {
            taskId =1;
        }
        return taskId;
    }
    public String getTaskDesc() {
        return taskDesc;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }


    public String getProject() {
        return project;
    }
    public boolean getStatus() {
         return this.status;
    }
public String getTaskDetails() {
        return " TaskID : "+this.taskId +
                ", Task Title: "+this.taskDesc +
                ", Due Date: "+this.dueDate+
                ", Project: "+this.project;
}
    @Override
    public int compareTo(Task taskId) {
        int compareTaskId = taskId.getTaskId();
        return this.taskId - compareTaskId;
    }
}
