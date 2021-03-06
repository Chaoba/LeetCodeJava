"""
151. Reverse Words in a String  QuestionEditorial Solution  My Submissions
Total Accepted: 111922
Total Submissions: 709805
Difficulty: Medium
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
"""


class Solution(object):
    def isBlank(self, s):
        return s != ''

    def reverseWords1(self, s):
        """
        :type s: str
        :rtype: str
        """
        temps = s.split(' ')
        temps = filter(self.isBlank, temps)
        result = temps[::-1]
        return ' '.join(result)

    def reverseWords2(self, s):
        result = s.split(' ')[::-1]
        return ' '.join(i for i in result if i != '')

    def reverseWords(self, s):
        return ' '.join(reversed(s.split()))
