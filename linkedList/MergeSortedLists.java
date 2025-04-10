// 21 - Merge two sorted lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mainListHead = null;
        ListNode mainListNext = null;
        ListNode list1Head = list1;
        ListNode list2Head = list2;

        while (!(list1Head == null && list2Head == null)) {
            if (list1Head == null) {
                if (mainListHead == null) {
                    mainListNext = list2Head;
                    mainListHead = mainListNext;
                } else {
                    mainListNext.next = list2Head;
                    mainListNext = mainListNext.next;
                }
                list2Head = list2Head.next;
            } else if (list2Head == null) {
                if (mainListHead == null) {
                    mainListNext = list1Head;
                    mainListHead = mainListNext;
                } else {
                    mainListNext.next = list1Head;
                    mainListNext = mainListNext.next;
                }
                list1Head = list1Head.next;
            } else if (list2Head.val <= list1Head.val) {
                if (mainListHead == null) {
                    mainListNext = list2Head;
                    mainListHead = mainListNext;
                } else {
                    mainListNext.next = list2Head;
                    mainListNext = mainListNext.next;
                }
                list2Head = list2Head.next;
            } else {
                if (mainListHead == null) {
                    mainListNext = list1Head;
                    mainListHead = mainListNext;
                } else {
                    mainListNext.next = list1Head;
                    mainListNext = mainListNext.next;
                }
                list1Head = list1Head.next;
            }
        }
        return mainListHead;
    }
}
