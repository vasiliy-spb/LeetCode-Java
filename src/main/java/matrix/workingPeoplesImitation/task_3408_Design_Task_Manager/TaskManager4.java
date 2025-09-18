package matrix.workingPeoplesImitation.task_3408_Design_Task_Manager;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// from leetcode code sample (2)
public class TaskManager4 {
    PriorityQueue<Task> ts = new PriorityQueue<>((a, b) -> (a.priority == b.priority) ? b.tid - a.tid : b.priority - a.priority);
    HashMap<Integer, Task> idMap = new HashMap<>();

    public TaskManager4(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks) {
            int uid = t.get(0);
            int tid = t.get(1);
            int p = t.get(2);
            Task newTask = new Task(uid, tid, p);
            idMap.put(tid, newTask);
            ts.add(newTask);
        }
    }

    public void add(int uid, int tid, int p) {
        Task newTask = new Task(uid, tid, p);
        idMap.put(tid, newTask);
        ts.add(newTask);
    }

    public void edit(int taskId, int np) {
        Task t = idMap.get(taskId);
        int uid = t.uid;
        Task newT = new Task(uid, taskId, np);
        ts.add(newT);
        idMap.put(taskId, newT);
    }

    public void rmv(int taskId) {
        idMap.remove(taskId);
    }

    public int execTop() {
        while (!ts.isEmpty()) {
            Task t = ts.poll();
            if (idMap.get(t.tid) != t) {
                continue;
            }
            return t.uid;
        }
        return -1;
    }

    class Task {
        public int uid, tid, priority;

        public Task(int uid, int tid, int priority) {
            this.uid = uid;
            this.tid = tid;
            this.priority = priority;
        }
    }
}
