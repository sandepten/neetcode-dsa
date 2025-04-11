// 1472. Design Browser History

class BrowserHistory {
    class Node {
        String val;
        Node next;
        Node prev;

        public Node(String val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }

    public void visit(String url) {
        Node newVisit = new Node(url);
        Node prev = curr;
        prev.next = newVisit;
        curr = newVisit;
        curr.prev = prev;
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (curr.prev == null) {
                return curr.val;
            }
            curr = curr.prev;
        }
        return curr.val;
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (curr.next == null) {
                return curr.val;
            }
            curr = curr.next;
        }
        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
