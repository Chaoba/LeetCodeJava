/**
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?**/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode * front = head;
        while(n > 0){
        	front = front->next;
        	n --;
        }
        if(front == nullptr){
        	head = head -> next;
        	return head;
        }
        
        ListNode* pre = nullptr;
        ListNode* current = head;
        ListNode* next = current.next;

        while(front != nullptr){
        	front = front -> next;
        	pre = current;
        	current = next;
        	next = next -> next;
        }
        pre -> next = next;
        return head;
    }
};