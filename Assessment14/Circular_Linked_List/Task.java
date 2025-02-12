import java.time.LocalDate;

class Task {
    int taskID, priority;
    String taskName;
    LocalDate dueDate;
    Task next;

    Task(int taskID, String taskName, int priority, LocalDate dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    Task head, tail, currentTask;

    void addTaskAtEnd(int taskID, String taskName, int priority, LocalDate dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = tail = currentTask = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    void addTaskAtBegin(int taskID, String taskName, int priority, LocalDate dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = tail = currentTask = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    void addTaskAtPos(int taskID, String taskName, int priority, LocalDate dueDate, int position) {
        if (position <= 1 || head == null) {
            addTaskAtBegin(taskID, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskID, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) tail = newTask;
    }

    void removeTask(int taskID) {
        if (head == null) return;

        Task temp = head, prev = null;

        do {
            if (temp.taskID == taskID) {
                if (temp == head && temp == tail) {
                    head = tail = currentTask = null;
                } else {
                    if (temp == head) head = head.next;
                    if (temp == tail) tail = prev;
                    if (prev != null) prev.next = temp.next;
                }
                tail.next = head;
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void viewCurrentTask() {
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due: " + currentTask.dueDate);
        } else {
            System.out.println("No tasks available.");
        }
    }

    void moveToNextTask() {
        if (currentTask != null) {
            currentTask = currentTask.next;
            viewCurrentTask();
        }
    }

    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        do {
            System.out.println("Task ID: " + temp.taskID + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) return;

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskID + ", Name: " + temp.taskName + ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) System.out.println("No tasks found with priority " + priority);
    }
}

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addTaskAtEnd(101, "Submit Assignment", 2, LocalDate.of(2025, 2, 15));
        scheduler.addTaskAtEnd(102, "Project Presentation", 1, LocalDate.of(2025, 2, 20));
        scheduler.addTaskAtEnd(103, "Meeting with Advisor", 3, LocalDate.of(2025, 2, 18));

        scheduler.displayTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();

        System.out.println("\nMoving to Next Task:");
        scheduler.moveToNextTask();

        System.out.println("\nSearching for tasks with priority asked:");
        scheduler.searchByPriority(1);

        System.out.println("\nRemoving Task ID asked");
        scheduler.removeTask(102);
        scheduler.displayTasks();
    }
}
