/******************************************************************************************************************************************************
-------------------------
Level- Medium
Question No- 377
------------------------
___________________________________________________________________________________________________

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.

Example 2:

Input: nums = [9], target = 3
Output: 0

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target + 1];
        return recurse(nums, target, memo);
    }
    
    public int recurse(int[] nums, int remain, Integer[] memo){
        
        if(remain < 0) return 0;
        if(memo[remain] != null) return memo[remain];
        if(remain == 0) return 1;
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += recurse(nums, remain - nums[i], memo);
        }
        
        memo[remain] = ans;
        return memo[remain];
    }
}
