"""
82. Remove Duplicates from Sorted List II  QuestionEditorial Solution  My Submissions
Total Accepted: 80224
Total Submissions: 290201
Difficulty: Medium
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
"""


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None:
            return head

        # remove the duplicated head
        duplicateHead = False
        while head.next is not None and head.val == head.next.val:
            duplicateHead = True
            head = head.next

        if duplicateHead:
            head = head.next
            return self.deleteDuplicates(head)

        p = head
        q = head.next
        duplicated = False
        while q is not None and q.next is not None:
            # find the duplicated nodes
            while q.next is not None and q.val == q.next.val:
                duplicated = True
                q = q.next

            if duplicated:
                # remove these duplicated nodes
                p.next = q.next
                q = p.next
                duplicated = False
            else:
                # no duplicated node, continue to find the next one
                p = q
                q = q.next

        return head
