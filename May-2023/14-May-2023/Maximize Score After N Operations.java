/******************************************************************************************************************************************************
-----------------------
Level- Hard
Question NO- 1799
-------------------------
You are given nums, an array of positive integers of size 2 * n. You must perform n operations on this array.

In the ith operation (1-indexed), you will:

    Choose two elements, x and y.
    Receive a score of i * gcd(x, y).
    Remove x and y from nums.

Return the maximum score you can receive after performing n operations.

The function gcd(x, y) is the greatest common divisor of x and y.

___________________________________________________________________________________________________
 

Example 1:

Input: nums = [1,2]
Output: 1
Explanation: The optimal choice of operations is:
(1 * gcd(1, 2)) = 1

Example 2:

Input: nums = [3,4,6,8]
Output: 11
Explanation: The optimal choice of operations is:
(1 * gcd(3, 6)) + (2 * gcd(4, 8)) = 3 + 8 = 11

Example 3:

Input: nums = [1,2,3,4,5,6]
Output: 14
Explanation: The optimal choice of operations is:
(1 * gcd(1, 5)) + (2 * gcd(2, 4)) + (3 * gcd(3, 6)) = 1 + 4 + 9 = 14


___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int maxScore(int[] nums) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, 1, 0, memo);
    }
    private int helper(int[] nums, int i, int mask, Map<String, Integer> memo) {
        if (i > nums.length / 2) {
            return 0;
        }

        String key = i + "," + mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxScore = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((mask & (1 << j)) == 0) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((mask & (1 << k)) == 0) {
                        int newMask = mask | (1 << j) | (1 << k);
                        int score = i * gcd(nums[j], nums[k]) + helper(nums, i + 1, newMask, memo);
                        maxScore = Math.max(maxScore, score);
                    }
                }
            }
        }

        memo.put(key, maxScore);
        return maxScore;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
