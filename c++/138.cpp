/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
**/



#include <stdio.h>
#include<iostream>
#include <vector>
#include <string>
#include <queue>
#include <map>
using namespace std;
  struct RandomListNode {
      int label;
      RandomListNode *next, *random;
      RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
  };


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();


class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(!head) return head;
        RandomListNode * re;
        map<RandomListNode *, int> originMap;
        map<int, RandomListNode*> copyMap;
        RandomListNode * i = head;
        RandomListNode * j =NULL;
        int index = 0;
        while(i) {
            RandomListNode * temp = new RandomListNode(i->label);
            if(j){
                j -> next = temp;
                j =  temp;
            } else{
                re = temp;
                j = temp;
            }

            originMap.insert(pair<RandomListNode*, int>(i, index));
            copyMap.insert(pair<int, RandomListNode*>(index, temp));
            index ++;
            i = i -> next;

        }

        j = re;
        i = head;
        while(i){
            if(i -> random){
                int randomIndex = originMap[i->random];
                j -> random = copyMap[randomIndex];
            }
            i = i->next;
            j = j->next;
        }

        return re;
    }
};

int main(int argc, char** argv) {
	Solution s;
	RandomListNode *head = new RandomListNode(1);
//	RandomListNode *two = new RandomListNode(2);
//	head->next = two;
//	head->random = two;
//	two->random = two;
	RandomListNode * temp = head;
	for(int i = 1 ;i< 10;i++) {
	    	RandomListNode *node = new RandomListNode(i);
	    	temp->next = node;
	    	node->random = temp;
	    	temp = node;
	}
    RandomListNode * re = s.copyRandomList(head);
    while(re){
        cout<<"label:"<<re->label<<endl;
        if(re->random){
            cout<<"random:"<<re->random->label<<endl;
        }
        re = re->next;
    }

	}