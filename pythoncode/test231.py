import unittest

from Algorithm231 import Solution


class Test231(unittest.TestCase):
    def test1(self):
        s = Solution()
        self.assertTrue(s.isPowerOfTwo(1))
        self.assertTrue(s.isPowerOfTwo(2))
        self.assertTrue(s.isPowerOfTwo(8))
        self.assertTrue(s.isPowerOfTwo(64))
        self.assertTrue(s.isPowerOfTwo(1024))
        self.assertFalse(s.isPowerOfTwo(0))


if __name__ == '__main__':
    unittest.main()
