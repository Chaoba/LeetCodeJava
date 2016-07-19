package com.mushuichuan;

import com.mushuichuan.beans.ListNode;

/**
 * 2. Add Two Numbers  QuestionEditorial Solution  My Submissions
 * Total Accepted: 158939
 * Total Submissions: 659750
 * Difficulty: Medium
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Created by Liyanshun on 2016/7/18.
 */
public class Algorithm2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1, p = l1;
        int addOne = 0;
        while (l1 != null && l2 != null) {
            p = l1;
            l1.val += l2.val + addOne;
            if (l1.val >= 10) {
                l1.val %= 10;
                addOne = 1;
            } else {
                addOne = 0;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        p.next = l1 == null ? l2 : l1;

        while (addOne == 1) {
            if (p.next == null) {
                p.next = new ListNode(1);
                addOne = 0;
            } else {
                p = p.next;
                p.val += 1;
                if (p.val >= 10) {
                    p.val %= 10;
                    addOne = 1;
                } else {
                    addOne = 0;
                }
            }
        }
        return head;
    }
}
