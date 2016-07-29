import unittest

from Algorithm92 import Solution
from testUtil import TestUtil


class Test92(unittest.TestCase):
    def test1(self):
        util = TestUtil()
        list =util.creatList([0, 1, 2, 4, 5, 7])
        solution= Solution()
        result=solution.reverseBetween(list,2,3)
        self.assertEquals("021457", util.printList(result))

    def test2(self):
        util = TestUtil()
        list = util.creatList([0, 1, 2, 4, 5, 7])
        solution = Solution()
        result = solution.reverseBetween(list, 4, 4)
        self.assertEquals("012457", util.printList(result))

    def test3(self):

        util = TestUtil()
        list = util.creatList([ 1, 2, 3,4, 5])
        solution = Solution()
        result = solution.reverseBetween(list, 2, 4)
        self.assertEquals("14325", util.printList(result))

    def test4(self):
        util = TestUtil()
        list = util.creatList([ 5])
        solution = Solution()
        result = solution.reverseBetween(list, 1, 1)
        self.assertEquals("5", util.printList(result))

    def test5(self):

        util = TestUtil()
        list = util.creatList([3,5])
        solution = Solution()
        result = solution.reverseBetween(list, 1, 1)
        self.assertEquals("35", util.printList(result))


    def test6(self):
        util = TestUtil()
        list = util.creatList([3, 5])
        solution = Solution()
        result = solution.reverseBetween(list, 1, 2)
        self.assertEquals("53", util.printList(result))



if __name__ == '__main__':
    unittest.main()
