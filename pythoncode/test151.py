import unittest

from Algorithm151 import Solution
from testUtil import TestUtil


class Test151(unittest.TestCase):
    def test1(self):
        solution = Solution()
        result = solution.reverseWords("the sky is blue")
        self.assertEquals("blue is sky the", result)

    def test2(self):
        solution = Solution()
        result = solution.reverseWords("   a   b    c    d  ")
        self.assertEquals("d c b a", result)

    def test3(self):
        solution = Solution()
        result = solution.reverseWords("  abd  ccca sss  ")
        self.assertEquals("sss ccca abd", result)


if __name__ == '__main__':
    unittest.main()
