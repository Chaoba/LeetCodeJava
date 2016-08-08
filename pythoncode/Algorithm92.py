# coding=utf-8
"""
92. Reverse Linked List II  QuestionEditorial Solution  My Submissions
Total Accepted: 78593
Total Submissions: 273921
Difficulty: Medium
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
"""
from ListNode import ListNode


class Solution:
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head

        if 1 == m:
            p = head
            index = 0
        else:
            index = 1
            i = head
            while index < m - 1:
                index = index + 1
                i = i.next
            p = i.next
        if p is not None:
            q = p.next
        if q is not None:
            r = q.next

        j = p;
        while q is not None and index < n - 1:
            index = index + 1
            q.next = p
            p = q
            q = r
            if r is not None:
                r = r.next
        j.next = q
        if m != 1:
            i.next = p
        else:
            head = p
        return head
