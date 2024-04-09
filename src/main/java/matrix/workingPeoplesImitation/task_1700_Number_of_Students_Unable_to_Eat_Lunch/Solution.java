package matrix.workingPeoplesImitation.task_1700_Number_of_Students_Unable_to_Eat_Lunch;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int index = 0;
        while (students[index] == sandwiches[index])
            index++;
        Queue<Integer> studentsQueue = new ArrayDeque<>();
        for (int i = index; i < students.length; i++) {
            if (students[i] == sandwiches[index]) index++;
            else studentsQueue.offer(students[i]);
        }
        if (studentsQueue.size() == 0) return 0;
        while (index < sandwiches.length) {
            int size = studentsQueue.size();
            boolean eat = false;
            for (int i = 0; i < size; i++) {
                int student = studentsQueue.poll();
                if (student == sandwiches[index]) {
                    index++;
                    eat = true;
                }
                else studentsQueue.offer(student);
            }
            if (!eat) break;
        }
        return studentsQueue.size();
    }
}
