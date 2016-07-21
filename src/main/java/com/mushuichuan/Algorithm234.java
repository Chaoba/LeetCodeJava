package com.mushuichuan;

import com.mushuichuan.beans.ListNode;

/**
 * 234. Palindrome Linked List  QuestionEditorial Solution  My Submissions
 * Total Accepted: 57033
 * Total Submissions: 193587
 * Difficulty: Easy
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * Created by Liyanshun on 2016/7/21.
 */
public class Algorithm234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode temp = head, pre = head, next = head.next;
        ListNode middle = head;

        while (middle.next != null && middle.next.next != null) {
            //middle move two stops every time
            middle = middle.next.next;
            //reverse the first half list
            pre = temp;
            temp = next;
            next = next.next;
            temp.next = pre;

        }
        if (middle.next == null) {
            temp = temp.next;
        }
        while (next != null) {
            if (temp.val != next.val) {
                return false;
            }
            temp = temp.next;
            next = next.next;
        }
        return true;
    }
}
