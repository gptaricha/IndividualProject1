import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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

    public Task(int taskId, String desc, Date date, String projectId) {
        this.taskId = taskId;
        this.taskDesc = desc;
        this.dueDate = date;
        project = projectId;
    }

    public Task() {

    }

    public void createTask() {
        System.out.println("HAHAHAHHA");
        System.out.println("change it");
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

    public String getProject() {
        return project;
    }

    public String getTaskDetails() {
        return getTaskId() + " : " + getTaskDesc() + " : " + getDueDate() + " : " + getProject();
    }

    @Override
    public int compareTo(Task taskId) {
        int compareTaskId = ((Task) taskId).getTaskId();
        return this.taskId - compareTaskId;
    }
}
