import java.util.*;

class Process {
    int processID, burstTime, remainingTime, priority, waitingTime, turnaroundTime;
    Process next;

    Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    Process head, tail;
    int timeQuantum;

    RoundRobinScheduler(int timeQuantum) {
        this.head = this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    void removeProcess(int processID) {
        if (head == null) return;

        Process temp = head, prev = null;
        do {
            if (temp.processID == processID) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    if (temp == head) head = head.next;
                    if (temp == tail) tail = prev;
                    if (prev != null) prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    void simulateRoundRobin() {
        if (head == null) return;

        int currentTime = 0;
        List<Process> completedProcesses = new ArrayList<>();

        Process temp = head;
        while (completedProcesses.size() < getTotalProcesses()) {
            if (temp.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, temp.remainingTime);
                temp.remainingTime -= executionTime;
                currentTime += executionTime;

                if (temp.remainingTime == 0) {
                    temp.turnaroundTime = currentTime;
                    temp.waitingTime = temp.turnaroundTime - temp.burstTime;
                    completedProcesses.add(temp);
                    removeProcess(temp.processID);
                }
            }
            temp = temp.next;
            displayProcesses();
        }

        displayAverageTimes(completedProcesses);
    }

    int getTotalProcesses() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.print("Processes in Queue: ");
        do {
            System.out.print("[P" + temp.processID + " (" + temp.remainingTime + ")] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    void displayAverageTimes(List<Process> completedProcesses) {
        double totalWaitingTime = 0, totalTurnaroundTime = 0;
        for (Process p : completedProcesses) {
            totalWaitingTime += p.waitingTime;
            totalTurnaroundTime += p.turnaroundTime;
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / completedProcesses.size()));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / completedProcesses.size()));
    }
}

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(3);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 2);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.println("\nSimulating Round-Robin Scheduling:");
        scheduler.simulateRoundRobin();
    }
}
