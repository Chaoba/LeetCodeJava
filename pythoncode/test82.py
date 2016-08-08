import unittest

from Algorithm82 import Solution
from testUtil import TestUtil


class Test92(unittest.TestCase):
    def test1(self):
        util = TestUtil()
        list = util.creatList([0, 1, 2, 2, 3, 4])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("0134", util.printList(result))

    def test8(self):
        util = TestUtil()
        list = util.creatList([1, 2, 3, 3, 4, 4, 5])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("125", util.printList(result))

    def test2(self):
        util = TestUtil()
        list = util.creatList([1, 1, 1, 2, 3])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("23", util.printList(result))

    def test3(self):
        util = TestUtil()
        list = util.creatList([1, 1, 1, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("26", util.printList(result))

    def test4(self):
        util = TestUtil()
        list = util.creatList([])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("", util.printList(result))

    def test5(self):
        util = TestUtil()
        list = util.creatList([1, 1])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("", util.printList(result))

    def test6(self):
        util = TestUtil()
        list = util.creatList([1, 2, 2])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("1", util.printList(result))

    def test7(self):
        util = TestUtil()
        list = util.creatList([1, 1, 2, 2, 3, 3])
        solution = Solution()
        result = solution.deleteDuplicates(list)
        self.assertEquals("", util.printList(result))


if __name__ == '__main__':
    unittest.main()
