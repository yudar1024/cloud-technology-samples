""" 要求去掉数组类的重复元素，同时空间复杂度必须是O(1)"""
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums)==1:
            return 1
        if nums==None:
            return 0


        begin = 1
        for index1,value1 in enumerate(nums):
            # if value1 ==nums[index1-1]:
            #     nums.pop(index1)
            for index2, value2 in enumerate(nums[begin:]):
                # if value1 ==value2 and  index2 != index1:
                #     nums.pop(index2)
                if value1==value2 :
                    nums.remove(value2)
                else:
                    break

            begin+=1
            if begin==len(nums):
                break

        return len(nums)

if __name__ == '__main__':
    s = Solution()
    array=[0,0,0,0]
    array2 = [1, 1, 2]
    array3=[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    length = s.removeDuplicates(array3)

    print("length1 = {0}".format(length))
