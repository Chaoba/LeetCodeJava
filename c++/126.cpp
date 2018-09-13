/**
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
**/

#include <stdio.h>
#include<iostream>
#include <vector>
#include <string>
#include <queue>
using namespace std;


static vector<vector<char> > board =[](){
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    return vector<vector<char> >{};
}();

class Solution {
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> result;
        vector<int> tag(wordList.size(), INT_MAX);
        vector<int> tag1(wordList.size(), INT_MAX);
        bool containEnd = false;
        for(int i = 0;i < wordList.size();i++) {
            if(wordList[i] == endWord) {
                containEnd = true;
                break;
            }
        }
        if(!containEnd) {
            return result;
        }

        vector<vector<string>> beginQueue;
        beginQueue.push_back({beginWord});
        vector<vector<string>> endQueue;
        endQueue.push_back({endWord});
        int begin = 1;
        int end = 1;
        bool find = false;
        while(!find && begin + end <= wordList.size() + 1){
//            cout<<"being:"<<begin<<"  end:"<<end<<endl;
            findNextLevel(wordList, beginQueue, tag);
//            cout<<"begin size:"<<beginQueue.size()<<"   end size:"<< endQueue.size()<<endl;
//            cout<<beginQueue.front()[0]<<endl;
            begin++;
//[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
            for(auto begin : beginQueue){
                for(auto end: endQueue) {
//                   cout<<begin.back()<<"===="<<end.back()<<endl;

                    if(begin.back() == end.back()) {

                        find = true;
                        vector<string> temp;
                        temp.insert(temp.end(), begin.begin(), begin.end());
                         if(end.size() > 1){
                            temp.insert(temp.end(), end.rbegin() + 1 , end.rend());
                        }
                        result.push_back(temp);
                    }
                }
            }
            if(find) break;
            findNextLevel(wordList, endQueue, tag1);
            for(auto begin : beginQueue){
                for(auto end: endQueue) {
                    if(begin.back() == end.back()) {
//                        cout<<"find"<<endl;
                        find = true;
                        vector<string> temp;
                        temp.insert(temp.end(), begin.begin(), begin.end());
                        if(end.size() > 1){
                            temp.insert(temp.end(), end.rbegin() + 1 , end.rend());
                        }
                        result.push_back(temp);
                    }
                }
            }
            end++;
        }
        return result;
    }

    void findNextLevel(vector<string>& wordList, vector<vector<string>>& q, vector<int>& tag){
         int size = q.size();
         vector<int> index;
         for(int i = 0; i< size; i++){
            vector<string> v = q[i];
            for(int i = 0; i < tag.size();i++) {
                if(tag[i] == INT_MAX && isClose(wordList[i],v.back())){
//                    cout<<"iscolse:"+wordList[i]<<"==="<<v.back()<<endl;
                    index.push_back(i);
                    vector<string> newV = v;
                    newV.push_back(wordList[i]);
                    q.push_back(newV);
                }
            }
         }
         for(auto i: index){
            tag[i] = 1;
         }
         q.erase(q.begin(), q.begin() + size);
    }
     vector<vector<string>> findLadders1(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<string>> result;
        bool containEnd = false;
        for(auto s : wordList) {
            if(s == endWord) {
                containEnd = true;
                break;
            }
        }
        if(!containEnd) {
            return result;
        }

        vector<int> tag(wordList.size(), 1);
        vector<string> temp;
        temp.push_back(beginWord);
        find(result,temp, beginWord, endWord, wordList,tag);
        return result;
    }

    void find(vector<vector<string>> & result, vector<string> temp, string beginWord, string endWord, vector<string>& wordList, vector<int>& tag) {
        cout<<temp.size()<<endl;
        if(!result.empty() && temp.size() > result[0].size()){
            return;
        }
        if(beginWord == endWord) {
            vector<string> v  = temp;
            if(result.empty()){
                result.push_back(v);
            }else {
                if(temp.size() < result[0].size()){
                    result.clear();
                    result.push_back(v);
                }else if(temp.size() == result[0].size()){
                    result.push_back(v);
                }else {
                    return;
                }
            }
        }

        for(int i = 0; i< tag.size(); i++){
            if(tag[i] && isClose(beginWord, wordList[i])) {
                temp.push_back(wordList[i]);
                tag[i] = 0;
                find(result,temp, wordList[i], endWord, wordList, tag);
                temp.pop_back();
                tag[i] = 1;
            }
        }
    }

    bool isClose(string& a, string &b){
//    if(a=="rex")
//    cout<<"isclose"<< a <<"===="<<b<<endl;
        int diff = 0;
        for(int i = 0; i < a.size(); i++){
            if(a[i] != b[i]){
                diff++;
                if(diff > 1) return false;
            }
        }

        return diff == 1;
    }
};

int main(int argc, char** argv) {
	Solution s;
	vector<string> v ={"ted","tex","red","tax","tad","den","rex","pee"};
	vector<vector<string>> r=s.findLadders("red","tax",v);
	for(auto a: r){
	    for(auto b : a) {
	        cout<< b<<" ";
	    }
	    cout<<endl;
	}
//
//	vector<string> v ={"hot","dot","dog","lot","log","cog"};
//	vector<vector<string>> r=s.findLadders("hit","cog",v);
//	for(auto a: r){
//	    for(auto b : a) {
//	        cout<< b<<" ";
//	    }
//	    cout<<endl;
//	}
//
//
//	vector<string> v1 ={"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
//	vector<vector<string>> r1=s.findLadders("qa","sq",v1);
//	for(auto a: r1){
//	    for(auto b : a) {
//	        cout<< b<<" ";
//	    }
//	    cout<<endl;
//	}
//
//
//	vector<string> v2 ={"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
//	vector<vector<string>> r2=s.findLadders("cet","ism",v2);
//	for(auto a: r2){
//	    for(auto b : a) {
//	        cout<< b<<" ";
//	    }
//	    cout<<endl;
//	}
}