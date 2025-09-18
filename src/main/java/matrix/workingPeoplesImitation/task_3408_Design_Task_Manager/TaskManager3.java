package matrix.workingPeoplesImitation.task_3408_Design_Task_Manager;

import java.util.List;
import java.util.PriorityQueue;

// from leetcode code sample (1)
class TaskManager3 {
    int[] priorities = new int[100001];
    int[] userIds = new int[100001];
    PriorityQueue<Long> PQ = new PriorityQueue<>((a, b) -> Long.compare(b, a));

    public TaskManager3(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);
            priorities[taskId] = priority;
            userIds[taskId] = userId;
            PQ.offer((long) priority * 100001 + taskId);
        }
    }

    public void add(int userId, int taskId, int priority) {
        if (priorities[taskId] > 0)
            return;
        priorities[taskId] = priority;
        userIds[taskId] = userId;
        PQ.offer((long) priority * 100001 + taskId);
    }

    public void edit(int taskId, int newPriority) {
        priorities[taskId] = newPriority;
        PQ.offer((long) newPriority * 100001 + taskId);
    }

    public void rmv(int taskId) {
        priorities[taskId] = -1;
    }

    public int execTop() {
        while (!PQ.isEmpty()) {
            long current = PQ.poll();
            int taskId = (int) (current % 100001);
            int priority = (int) (current / 100001);
            if (priorities[taskId] != priority)
                continue;
            priorities[taskId] = -1;
            return userIds[taskId];
        }
        return -1;
    }
}
