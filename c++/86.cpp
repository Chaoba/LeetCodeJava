/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
**/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <stack>
#include <string>
using namespace std;


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();

  struct ListNode {
      int val;
      ListNode *next;
     ListNode(int x) : val(x), next(NULL) {}
  };

class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* frontHead = NULL;
        ListNode* front = NULL;
        ListNode* end = NULL;
        ListNode* endHead = NULL;
        ListNode* temp = head;

        while(temp != NULL) {
            if(temp -> val < x) {
                if(frontHead == NULL) {
                    frontHead = temp;
                } else {
                    front ->next = temp;
                }
                front = temp;
            } else{
                if(endHead == NULL) {
                    endHead = temp;
                }else {
                    end -> next = temp;
                }
                end = temp;
            }
            cout<<"======"<<temp->val<<endl;
            temp = temp -> next;
        }
        if(frontHead == NULL){
            return endHead;
        }
        if(end){
            end->next = NULL;
        }
        front -> next = endHead;
        return frontHead;
    }
};


int main() {
	Solution s;
	vector<int> val = {1,4,3,2,5,2};
	ListNode* head = NULL;
	ListNode* tail = NULL;
	for(auto v : val){
	    ListNode* node= new ListNode(v);
	    if(head == NULL){
	        head = node;
	        tail = node;
	    }else {
	        tail -> next = node;
	        tail =node;
	    }
	}
	int i = 0;
//	while(head){
//	if(i< 10){
//	    cout<<head->val<<endl;
//	    i++;
//	    }
//	    head = head->next;
//	}
	ListNode* r = s.partition(head,);
	while(r){
	    cout<<r->val<<endl;
	    r = r->next;
	}
	}