/******************************************************************************************************************************************************
-------------------------
QUESTION NO-540
-------------------------
You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

---------------------------------------------------------------------------------------

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

Approach-1
----------------------
  
class Solution {
    public int singleNonDuplicate(int[] nums) {

        int ans = 0;
        for(int i=0; i<nums.length; i++){

            ans = ans^nums[i];
        }
        return ans;
        
    }
}

-----------------------
Approach-2
-------------------------
  
 class Solution {
    public int singleNonDuplicate(int[] nums) {

        int start = 0 ; int end = nums.length -2 ;

        while(start <= end){
            int mid = start + (end - start)/2;
            
            if(nums[mid] == nums[mid^1]){
                start = mid + 1 ;
            }else{
                end  = mid -1 ;
            }
        }
        return nums[start];
    }
}
