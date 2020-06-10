"""求数组的中心索引，中心索引指该索引的左边所有数字之后等于该索引右边所有数字之和"""
from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        left_sum, total_sum, = 0, sum(nums)
        if len(nums) < 3:
            return -1
        for index, value in enumerate(nums):
            if left_sum*2==total_sum-value:
                return index
            left_sum = left_sum + value

        return -1



if __name__ == '__main__':
    s = Solution()
    result=s.pivotIndex([1, 7, 3, 6, 5, 6])
    print(result)