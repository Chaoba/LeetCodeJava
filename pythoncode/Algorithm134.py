"""
134. Gas Station  QuestionEditorial Solution  My Submissions
Total Accepted: 65969
Total Submissions: 236876
Difficulty: Medium
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
"""
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        start=0
        tatal_gas=0
        total_cost=0

        current_left=0
        for i, (g,c) in enumerate(zip(gas,cost)):
            tatal_gas+=g
            total_cost+=c

            current_left+=g-c
            if current_left<0:
                # need to reset
                start=i+1
                current_left=0

        return start if tatal_gas>=total_cost else -1