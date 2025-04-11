// 225. Implement Stack using Queues

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> stack;
    Queue<Integer> backupQueue;

    public MyStack() {
        stack = new LinkedList<Integer>();
        backupQueue = new LinkedList<Integer>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int curr = -1;
        while (!stack.isEmpty()) {
            curr = stack.poll();
            if (stack.peek() == null) {
                break;
            }
            backupQueue.add(curr);
        }

        while (!backupQueue.isEmpty()) {
            int backCurr = backupQueue.poll();
            stack.add(backCurr);
        }

        return curr;
    }

    public int top() {
        int curr = -1;
        while (!stack.isEmpty()) {
            curr = stack.poll();
            backupQueue.add(curr);
        }

        // move back, as now I know the end
        while (!backupQueue.isEmpty()) {
            int backCurr = backupQueue.poll();
            stack.add(backCurr);
        }

        return curr;
    }

    public boolean empty() {
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
