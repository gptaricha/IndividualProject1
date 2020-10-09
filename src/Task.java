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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Task extends Project implements Comparable<Task> {
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
            Date date1 = firstDate.getDueDate();
            Date date2 = secondDate.getDueDate();
            return date1.compareTo(date2);
        }
    };
    private int taskId;
    private String taskDesc;
    private Date dueDate;
    private String project;
    private String status;
    private DateFormat formatter;

     public Task(int taskId, String desc, Date date, String projectId) {
        this.taskId = taskId;
        this.taskDesc = desc;
        this.dueDate = date;
        project = projectId;
        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
    }
    public Task() {
    }

    public int getTaskId() {
        return taskId;
    }
    public String getTaskDesc() {
        return taskDesc;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public String getFormatDueDate() {
        return formatter.format(dueDate);
    }
    public String getProject() {
        return project;
    }

    public String getTaskDetails() {
        return getTaskId() + " ; " + getTaskDesc() + " ; " + formatter.format(getDueDate()) + " ; " + getProject();
    }

    @Override
    public int compareTo(Task taskId) {
        int compareTaskId = taskId.getTaskId();
        return this.taskId - compareTaskId;
    }
}
