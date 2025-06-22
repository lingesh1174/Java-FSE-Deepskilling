public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask(new Task(1, "Design database schema", "Pending"));
        manager.addTask(new Task(2, "Implement login", "In Progress"));
        manager.addTask(new Task(3, "Write unit tests", "Pending"));
        System.out.println("All Tasks:");
        manager.traverseTasks();
        System.out.println("\nSearch for Task with ID 2:");
        manager.searchTask(2);
        System.out.println("\nDelete Task with ID 1:");
        manager.deleteTask(1);
        System.out.println("\nTasks After Deletion:");
        manager.traverseTasks();
    }
}

class Task {
    int taskId;
    String taskName;
    String status;
    public Task(int taskId, String taskName, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }
    public void displayInfo(){
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

class TaskNode{
    Task task;
    TaskNode next;
    public TaskNode(Task task){
        this.task = task;
        this.next = null;
    }
}

class TaskManager {
    private TaskNode head;
    public TaskManager(){
        this.head = null;
    }
    public void addTask(Task task){
        TaskNode newNode = new TaskNode(task);
        if (head == null)
            head = newNode;
        else{
            TaskNode current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added: " + task.taskName);
    }
    public void searchTask(int id){
        TaskNode current = head;
        while (current != null){
            if (current.task.taskId == id){
                System.out.println("Task Found:");
                current.task.displayInfo();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + id + " not found.");
    }
    public void traverseTasks(){
        TaskNode current = head;
        if (current == null){
            System.out.println("No tasks available.");
            return;
        }
        while (current != null){
            current.task.displayInfo();
            current = current.next;
        }
    }
    public void deleteTask(int id){
        if (head == null){
            System.out.println("List is empty.");
            return;
        }
        if (head.task.taskId == id){
            head = head.next;
            System.out.println("Task with ID " + id + " deleted.");
            return;
        }
        TaskNode current = head;
        while (current.next != null){
            if (current.next.task.taskId == id){
                current.next = current.next.next;
                System.out.println("Task with ID " + id + " deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + id + " not found.");
    }
}