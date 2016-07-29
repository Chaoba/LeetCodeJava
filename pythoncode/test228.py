import unittest

from Algorithm228 import Solution228

class Test334(unittest.TestCase):
    def test1(self):
        s=Solution228()
        result=s.summaryRanges([0,1,2,4,5,7])
        self.assertEquals(["0->2","4->5","7"], result)

    def test2(self):
        s = Solution228()
        result = s.summaryRanges([0])
        self.assertEquals(["0"], result)

    def test3(self):
        s = Solution228()
        result = s.summaryRanges([0,1,2,3,4,5])
        self.assertEquals(["0->5"], result)

    def test4(self):
        s = Solution228()
        result = s.summaryRanges([])
        self.assertEquals([], result)

    def test5(self):

        s = Solution228()
        result = s.summaryRanges([1,3])
        self.assertEquals(["1","3"], result)

if __name__ == '__main__':
    unittest.main()