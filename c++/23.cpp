23.cpp
/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* head = nullptr;
        for (ListNode* node : lists) {
        	head = merge(head, node);
        }
        return head;
    }

    ListNode* merge(ListNode* left, ListNode* right){
    	if(!left) return right;
    	if(!right) return left;
    	
    	ListNode* result = nullptr;
    	ListNode* temp = nullptr;
    	while(left && right){
    		ListNode* small = nullptr;
    		if(left ->val < right->val){
    			samll = left;
    			left = left -> next;
    		} else {
    			small = right;
    			right = right -> next;
    		}

    		if(result){
    			temp -> next = small;
    		} else {
    			result = small;
    		}

    		temp = small;
    	}

    	if(left){
    		temp -> next = left;
    	}

    	if(right) {
    		temp -> next = right;
    	}
    	return result;
    }
};