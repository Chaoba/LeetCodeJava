"""
231. Power of Two  QuestionEditorial Solution  My Submissions
Total Accepted: 88808
Total Submissions: 233880
Difficulty: Easy
Given an integer, write a function to determine if it is a power of two.

Credits:
"""


class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return False if n <= 0 else (n & (n - 1)) == 0
