/******************************************************************************************************************************************************
---------------------------
Level- Medium
question No- 2348
--------------------------
Given an integer array nums, return the number of subarrays filled with 0.

A subarray is a contiguous non-empty sequence of elements within an array.

---------------------------------------------------------------------------------------

Example 1:

Input: nums = [1,3,0,0,2,0,0,4]
Output: 6
Explanation: 
There are 4 occurrences of [0] as a subarray.
There are 2 occurrences of [0,0] as a subarray.
There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
Example 2:

Input: nums = [0,0,0,2,0,0]
Output: 9
Explanation:
There are 5 occurrences of [0] as a subarray.
There are 3 occurrences of [0,0] as a subarray.
There is 1 occurrence of [0,0,0] as a subarray.
There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
Example 3:

Input: nums = [2,10,2019]
Output: 0
Explanation: There is no subarray filled with 0. Therefore, we return 0.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/
---------------------
Approach-1
----------------------
  class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long result = 0;
        int i=0;

        while(i < nums.length){
            long len = 0;

            if(nums[i] == 0){
                while(i < nums.length && nums[i] == 0){
                    len++;
                    i++;
                }
            }else{
                i++;
            }
            result += (len*(len+1))/2;
        }
        return result;

    }
}

---------------------
Approach-2
---------------------
  class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long result = 0;
        int count=0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                count++;
            }else{
                count = 0;
            }

            result += count;
        }
        return result;
    }
}
