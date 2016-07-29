"""
344. Reverse String  QuestionEditorial Solution  My Submissions
Total Accepted: 60679
Total Submissions: 103367
Difficulty: Easy
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".
"""


class Solution334:
    def reverseString(self, s):
        """
        :type s: str
        :rtype: str
        """
        return s[::-1];


if __name__ == '__main__':
    print'Start to run.'
    solution = Solution334()
    print solution.reverseString("sa")
