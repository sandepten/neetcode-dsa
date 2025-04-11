// 707. Design Linked List

class MyLinkedList {
    class Node {
        Integer val;
        Node next;
        Node prev;

        public Node(Integer val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node curr = head;

        for (int i = 0; i < index; i++) {
            if (curr == null) {
                return -1;
            }
            curr = curr.next;
        }
        if (curr == null) {
            return -1;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        Node curr = head;

        // get to the end
        while (curr.next != null) {
            curr = curr.next;
        }

        Node newTail = new Node(val);
        curr.next = newTail;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            if (curr == null) {
                return;
            }
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }

        Node prevNext = curr.next;
        Node newNode = new Node(val);
        curr.next = newNode;
        newNode.next = prevNext;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head == null) {
                return;
            }
            head = head.next;
            return;
        }

        Node curr = head;

        for (int i = 0; i < index - 1; i++) {
            if (curr == null) {
                return;
            }
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }

        Node toBeDeletedNode = curr.next;
        if (toBeDeletedNode == null) {
            return;
        }
        Node nextNext = toBeDeletedNode.next;
        curr.next = nextNext;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
