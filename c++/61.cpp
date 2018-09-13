/**
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <string>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();

class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head || k == 0) return head;
        int length = 1;
        int skip = 0;
        ListNode* first = head;
        ListNode* second = head;
        while(first -> next) {
            length ++;
            first = first -> next;
            if(skip < k){
                skip ++;
            } else {
                second = second -> next;
            }
        }

        if(skip == k) {
            first ->next = head;
            ListNode*  result = second -> next;
            second -> next = NULL;
            return result;
        } else {
            return rotateRight(head, k % length);
        }

    }
};

int main(int argc, char** argv) {
	Solution s;
	ListNode* head = new ListNode(1);

	ListNode* index = head;
	for(int i = 2; i<= 4;i++) {
	    ListNode* temp = new ListNode(i);
	    index -> next =  temp;
	    index = temp;
	}
	index = head;
	 while(index) {
        cout<< index->val;
        index = index -> next;
    }
    ListNode* result = s.rotateRight(head,4);
    while(result) {
        cout<< result->val;
        result = result -> next;
    }
}