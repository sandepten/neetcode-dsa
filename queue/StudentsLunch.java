// 1700. Number of Students Unable to Eat Lunch

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<Integer>();
        Queue<Integer> sandwichQueue = new LinkedList<Integer>();

        for (int i = 0; i < sandwiches.length; i++) {
            studentQueue.add(students[i]);
            sandwichQueue.add(sandwiches[i]);
        }

        int notMySandwitchCount = 0;
        while (!studentQueue.isEmpty() && notMySandwitchCount <= students.length) {
            if (studentQueue.peek() == sandwichQueue.peek()) {
                studentQueue.remove();
                sandwichQueue.remove();
                notMySandwitchCount = 0;
                continue;
            }
            int student = studentQueue.poll();
            studentQueue.add(student);
            notMySandwitchCount++;
        }

        if (!studentQueue.isEmpty()) {
            return studentQueue.size();
        }
        return 0;
    }
}
