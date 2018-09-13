/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
**/

class Solution {
public:
    vector<vector<string> > groupAnagrams(vector<string>& strs) {
        vector<vector<string> > result;
        unordered_map<string, multiset<string> > mp;
        for(auto s : strs) {
        	string t = s;
        	sort(t.begin(), t.end());
        	mp[t].insert(s);
        }

        for(auto m : mp) {
        	std::vector<string> v(m.second.begin(), m.second.end());
        	result.push_back(v);
        }

        return result;
    }
};