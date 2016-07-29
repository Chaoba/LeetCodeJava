"""
228. Summary Ranges  QuestionEditorial Solution  My Submissions
Total Accepted: 51802
Total Submissions: 203130
Difficulty: Medium
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
"""


class Solution228:
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        begin = 0
        end = 1
        result = []
        if len(nums) == 0:
            return result


        last = nums[0]

        while end < len(nums):
            if nums[end] - 1 != last:
                if begin==end-1:
                    result.append('%s' % nums[end-1])
                else:
                    result.append( '%s->%s' % (nums[begin], nums[end - 1]))
                begin = end;
            last = nums[end]
            end += 1


        if begin == end - 1:
            result.append('%s' % nums[end - 1])
        else:
            result.append( '%s->%s' % (nums[begin], nums[end - 1]))
        return result
