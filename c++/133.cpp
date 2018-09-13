/**
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
         **/
#include <stdio.h>
#include<iostream>
#include <vector>
#include <string>
#include <queue>
#include <map>
#include <set>
using namespace std;


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();

  struct UndirectedGraphNode {
      int label;
      vector<UndirectedGraphNode *> neighbors;
      UndirectedGraphNode(int x) : label(x) {};
  };
class Solution {
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if(!node) return node;
        set<int> labels;
        queue<UndirectedGraphNode *> nodeQueue;
        nodeQueue.push(node);
        map<int, UndirectedGraphNode *> copyMap;

        while(!nodeQueue.empty()){
            UndirectedGraphNode *temp = nodeQueue.front();
            nodeQueue.pop();
            labels.insert(temp->label);
            copyMap.insert(pair<int, UndirectedGraphNode *>(temp->label, new UndirectedGraphNode(temp->label)));
            for(auto neighbor : temp->neighbors) {
                if(labels.find(neighbor->label) == labels.end()){
                    nodeQueue.push(neighbor);
                }
            }
        }
         nodeQueue.push(node);
         labels.clear();
         while(!nodeQueue.empty()){
            UndirectedGraphNode *temp = nodeQueue.front();
            UndirectedGraphNode *copyNode = copyMap[temp->label];

            nodeQueue.pop();
            labels.insert(temp->label);
             for(auto neighbor : temp->neighbors) {
                copyNode->neighbors.push_back(copyMap[neighbor->label]);
                if(labels.find(neighbor->label) == labels.end()){
                    nodeQueue.push(neighbor);
                }
            }
         }

         return copyMap[node->label];
    }
};


int main(int argc, char** argv) {
    UndirectedGraphNode node0(0);
    UndirectedGraphNode node1(1);
    UndirectedGraphNode node2(2);
    node0.neighbors.push_back(&node1);
    node0.neighbors.push_back(&node2);
    node1.neighbors.push_back(&node2);
    node2.neighbors.push_back(&node2);
	Solution s;
	UndirectedGraphNode * re = s.cloneGraph(&node0);
    cout<<re->label<<endl;
    for(auto s : re->neighbors){
        cout<<s->label;
        for(auto ss : s->neighbors){
            cout<<"  ===::"<<ss->label;
        }
        cout<<endl;
    }

}