/******************************************************************************************************************************************************
-----------------------
Level- Medium
Question No-1318
-------------------------
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

___________________________________________________________________________________________________
 

Example 1:



Input: a = 2, b = 6, c = 5
Output: 3
Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
Example 2:

Input: a = 4, b = 2, c = 7
Output: 1
Example 3:

Input: a = 1, b = 2, c = 3
Output: 0

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
  public int minFlips(int a, int b, int c) {
    var cnt = 0;

    while (a>0 || b>0 || c>0) {
      if ((c & 1) == 0) {
        if ((a & 1) == 1) cnt++;
        if ((b & 1) == 1) cnt++;
      } else if ((a & 1) == 0 && (b & 1) == 0) cnt++;

      a >>= 1;
      b >>= 1;
      c >>= 1;
    }
    return cnt;
  }
}
