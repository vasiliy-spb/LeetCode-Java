package matrix.workingPeoplesImitation.task_3408_Design_Task_Manager;

import java.util.*;

// my solution
public class TaskManager {
    private Set<Integer> taskNumbers;
    private Queue<Task> heap;
    private Map<Integer, Task> taskIdTaskMap;
    private int nextNumber = 0;

    public TaskManager(List<List<Integer>> tasks) {
        this.taskNumbers = new HashSet<>();
        this.heap = new PriorityQueue<>((t1, t2) -> {
            if (Integer.compare(t2.priority, t1.priority) == 0) {
                return Integer.compare(t2.taskId, t1.taskId);
            }
            return Integer.compare(t2.priority, t1.priority);
        });
        this.taskIdTaskMap = new HashMap<>();
        for (List<Integer> task : tasks) {
            Task t = new Task(nextNumber++, task.get(0), task.get(1), task.get(2));
            heap.offer(t);
            taskIdTaskMap.put(task.get(1), t);
            taskNumbers.add(t.number);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(nextNumber++, userId, taskId, priority);
        taskIdTaskMap.put(taskId, task);
        heap.offer(task);
        taskNumbers.add(task.number);
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskIdTaskMap.get(taskId);
        heap.remove(task);
        task.priority = newPriority;
        heap.offer(task);
    }

    public void rmv(int taskId) {
        Task task = taskIdTaskMap.remove(taskId);
        taskNumbers.remove(task.number);
    }

    public int execTop() {
        while (!heap.isEmpty() && !taskNumbers.contains(heap.peek().number)) {
            heap.poll();
        }
        if (heap.isEmpty()) {
            return -1;
        }
        Task task = heap.poll();
        taskIdTaskMap.remove(task.taskId);
        return task.userId;
    }

    static class Task {
        int number;
        int userId;
        int taskId;
        int priority;

        public Task(int number, int userId, int taskId, int priority) {
            this.number = number;
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
}
