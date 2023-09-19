/******************************************************************************************************************************************************
-------------------------
Level- Medium
Question No- 287
-------------------------
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 
___________________________________________________________________________________________________

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int findDuplicate(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == nums[i+1]){
                ans = nums[i];
                break;
            }
        }

        return ans;
    }
}
