/******************************************************************************************************************************************************
------------------
Level- Easy
Question No- 905
-------------------
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

___________________________________________________________________________________________________ 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:

Input: nums = [0]
Output: [0]

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int[] sortArrayByParity(int[] nums) {

        for (int i = 0, j = 0; j < nums.length; j++){
            if (nums[j] % 2 == 0) {
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;;
            }
        }
        return nums;   
    }
}
