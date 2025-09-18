package daily.twentyfive.sep;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 3408. 设计任务管理器
 *
 * @author AhogeK
 * @since 2025-09-18 13:11:19
 */
public class DesignTaskManager {
    class TaskManager {
        private final HashMap<Integer, Task> idToTask;
        private final PriorityQueue<Task> taskList;
        public TaskManager(List<List<Integer>> tasks) {
            idToTask = new HashMap<>();
            taskList = new PriorityQueue<>(
                    (a, b) -> a.priority == b.priority ? b.taskId - a.taskId : b.priority - a.priority
            );
            tasks.forEach(task -> add(task.get(0), task.get(1), task.get(2)));
        }

        public void add(Integer userId, Integer taskId, Integer priority) {
            Task task = new Task(userId, taskId, priority);
            idToTask.put(taskId, task);
            taskList.add(task);
        }

        public void edit(int taskId, int newPriority) {
            Task task = new Task(idToTask.get(taskId).userId, taskId, newPriority);
            idToTask.get(taskId).delete = true;
            idToTask.put(taskId, task);
            taskList.add(task);
        }

        public void rmv(int taskId) {
            Task task = idToTask.get(taskId);
            task.delete = true;
            idToTask.remove(taskId);
        }

        public int execTop() {
            while (!taskList.isEmpty()) {
                Task topTask = taskList.poll();
                if (!topTask.delete) return topTask.userId;
            }
            return -1;
        }

        private static final class Task {
            int userId;
            int taskId;
            int priority;
            boolean delete;

            public Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
                this.delete = false;
            }
        }
    }
}
