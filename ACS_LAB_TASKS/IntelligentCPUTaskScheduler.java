import java.util.*;

public class IntelligentCPUTaskScheduler {
    static class Task {
        String name;
        int priority;
        int burstTime;

        Task(String name, int priority, int burstTime) {
            this.name = name;
            this.priority = priority;
            this.burstTime = burstTime;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of CPU tasks: ");
        int n = sc.nextInt();

        PriorityQueue<Task> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.priority != b.priority)
                        return Integer.compare(b.priority, a.priority);
                    return Integer.compare(a.burstTime, b.burstTime);
                });

        System.out.println("Enter: taskName priority burstTime");
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int priority = sc.nextInt();
            int burst = sc.nextInt();
            pq.offer(new Task(name, priority, burst));
        }

        System.out.println("\nCPU execution order:");
        int currentTime = 0;

        while (!pq.isEmpty()) {
            Task task = pq.poll();
            System.out.println(task.name + " | Priority: " + task.priority
                    + " | Start: " + currentTime
                    + " | End: " + (currentTime + task.burstTime));
            currentTime += task.burstTime;
        }
    }
}
