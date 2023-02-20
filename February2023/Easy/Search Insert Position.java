/******************************************************************************************************************************************************
--------------------------
QUESTION NO-35
--------------------------
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted 
in order.

You must write an algorithm with O(log n) runtime complexity.


---------------------------------------------------------------------------------------

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

Approach-1------O(N)
 ----------------------------------------------------------------------------
class Solution {

    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++){

            if (nums[i] == target || target < nums[i]) return i;
        }

        return nums.length;
    }
}

Approach-2---------------------O(logN)
 ------------------------------------------------------------------------------
  
 class Solution {

   public int searchInsert(int[] nums, int target) {

       int low = 0, high = nums.length;
       while(low < high) {

           // Calculate middle index
           int mid = low + (high - low)/2;
           if(target > nums[mid])
               low = mid + 1;
           else
               high = mid;
       }
       return low;
    }
}
