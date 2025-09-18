package matrix.workingPeoplesImitation.task_3408_Design_Task_Manager;

import java.util.*;

// from walkccc.me
public class TaskManager2 {
    private Map<Integer, Task> taskMap = new HashMap<>(); // {taskId: Task}
    private Set<Task> taskSet; // Stores tasks sorted by priority and taskId.

    public TaskManager2(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>();
        for (List<Integer> task : tasks)
            add(task.get(0), task.get(1), task.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        taskSet.remove(task);
        Task editedTask = new Task(task.userId, taskId, newPriority);
        taskSet.add(editedTask);
        taskMap.put(taskId, editedTask);
    }

    public void rmv(int taskId) {
        Task task = taskMap.get(taskId);
        taskSet.remove(task);
        taskMap.remove(taskId);
    }

    public int execTop() {
        if (taskSet.isEmpty())
            return -1;
        Task task = taskSet.iterator().next();
        taskSet.remove(task);
        taskMap.remove(task.taskId);
        return task.userId;
    }


    class Task implements Comparable<Task> {
        public int userId;
        public int taskId;
        public int priority;

        public Task() {
        }

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return this.priority == other.priority ? Integer.compare(other.taskId, this.taskId)
                    : Integer.compare(other.priority, this.priority);
        }
    }
}
