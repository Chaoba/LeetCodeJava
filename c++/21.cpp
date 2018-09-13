21.cpp
/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
**/
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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l1) return l2;
        if(!l2) return l1;

        ListNode* head = nullptr;
        ListNode* merge = nullptr;
        
        while(l1  && l2){
    	    ListNode* target = nullptr;
    	    if(l1 -> val < l2 ->val){
    	    	target = l1;
    	    	l1 = l1 -> next;
    	    } else {
    	    	target = l2;
    	    	l2 = l2 -> next;
    	    }
    	    if(head){
    	    	merge -> next = target;
    	    	merge = target;
    	    } else {
    	    	head = target;
    	    	merge = target;
    	    }
        }
        if(l1) {
        	merge -> next = l1;
        }
        if(l2) {
        	merge -> next = l2;
        }

        return head;

    }
};