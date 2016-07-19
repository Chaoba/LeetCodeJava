package com.mushuichuan;

import com.mushuichuan.beans.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Algorithm24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode l, r;
        l = head;
        r = head.next;
        head = r;
        do {
            l.next = r.next;
            r.next = l;
            l = l.next;
            if (l != null) {
                r = l.next;
            }
        } while (l != null && r != null);

        return head;
    }
}
