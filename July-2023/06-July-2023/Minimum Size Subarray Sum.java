/******************************************************************************************************************************************************
--------------------------
Level- Medium
Question no- 209
------------------------------

Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

___________________________________________________________________________________________________
 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) {
	    return 0;
    }
    int minLen = Integer.MAX_VALUE;
    int start = 0;
    int localSum = 0;
    for (int end = 0; end < nums.length; end++) {
	    localSum += nums[end];
	    while (localSum >= s) {
		    minLen = Math.min(minLen, end - start + 1);
		    localSum -= nums[start++];
	    }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
}
