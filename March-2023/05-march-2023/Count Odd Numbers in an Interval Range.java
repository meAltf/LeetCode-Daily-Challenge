/******************************************************************************************************************************************************
----------------------------------
LEVEL-EASY
QUESTION NO-1523
----------------------------------
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

---------------------------------------------------------------------------------------
 

Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
public:
    int countOdds(int low, int high) {
        int ans = 0;
		// iterate the given range
        for (int i = low; i <= high; i++) {
			// if it is odd, then increase ans by 1
			// alternatively, you can use `i % 2 == 1` in the condition
            if (i & 1) {
                ans += 1;
            }
        }
        return ans;
    }
};
