import unittest

from Algorithm334 import Solution334

class Test334(unittest.TestCase):
    def test1(self):
        s=Solution334()
        result=s.reverseString("ab")
        self.assertEquals("ba", result)

if __name__ == '__main__':
    unittest.main()