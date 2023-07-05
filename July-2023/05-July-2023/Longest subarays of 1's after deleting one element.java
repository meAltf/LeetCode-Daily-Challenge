/******************************************************************************************************************************************************
---------------------
Level- MEdium
Question No- 1493
----------------------
___________________________________________________________________________________________________

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int longestSubarray(int[] nums) {
	int longest = 0;
	int prev = 0, curr = 0;

	for (int bit : nums) {
		if (bit == 0) {
			prev = curr;
			curr = 0;
		} else {
			longest = Math.max(longest, prev + ++curr);
		}
	}

	return longest == nums.length ? longest - 1 : longest;
	}
}
