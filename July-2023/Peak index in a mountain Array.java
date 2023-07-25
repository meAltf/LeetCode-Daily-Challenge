/******************************************************************************************************************************************************
-----------------------
Level- Medium
Question No-852
-----------------------
An array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.

___________________________________________________________________________________________________

Example 1:

Input: arr = [0,1,0]
Output: 1

Example 2:

Input: arr = [0,2,1,0]
Output: 1

Example 3:

Input: arr = [0,10,5,2]
Output: 1

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
        public int peakIndexInMountainArray(int[] A) {

        for (int i = 1; i + 1 < A.length; ++i) if (A[i] > A[i + 1]) return i;
        // for (int i = A.length - 1; i > 0; --i) if (A[i] > A[i - 1]) return i;
        
        return 0;
    }
}
