/******************************************************************************************************************************************************
------------------------
Question No- 1444
Level- Hard
-------------------------
Given a rectangular pizza represented as a rows x cols matrix containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k.
You have to cut the pizza into k pieces using k-1 cuts. 

For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the cell boundary and cut the pizza into two pieces.
If you cut the pizza vertically, give the left part of the pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person.
Give the last piece of pizza to the last person.

Return the number of ways of cutting the pizza such that each piece contains at least one apple. Since the answer can be a huge number,
return this modulo 10^9 + 7.

---------------------------------------------------------------------------------------

Example 1:

Input: pizza = ["A..","AAA","..."], k = 3
Output: 3 
Explanation: The figure above shows the three ways to cut the pizza. Note that pieces must contain at least one apple.
Example 2:

Input: pizza = ["A..","AA.","..."], k = 3
Output: 1
Example 3:

Input: pizza = ["A..","A..","..."], k = 1
Output: 1

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

public class Solution {
    public int ways(String[] pizza, int k) {
        final int mod = 1000000000 + 7;
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][][] dp = new int[55][55][11];
        int[][] cnt = new int[55][55];

        for(int i = 1; i <= rows; i++)
            for(int j= 1; j <= cols; j++){
                cnt[i][j] = cnt[i-1][j] + cnt[i][j-1] - cnt[i-1][j-1] + (pizza[rows-i].charAt(cols-j) == 'A' ? 1 : 0);
            }
        for(int i = 0; i <= rows; i++) dp[i][0][0] = 1;

        for(int i = 0; i <= rows; i++)
            for(int j = 0; j<= cols; j++)
                for(int p = 0; p < k; p++)
                
                    if(dp[i][j][p] != 0){
                        for(int ii = i+1; ii <= rows; ii++)
                            if(cnt[ii][j] - cnt[i][j] > 0)
                                dp[ii][j][p+1] = (dp[ii][j][p+1] + dp[i][j][p]) % mod;
                        for(int jj = j+1; jj <= cols; jj++)
                            if(cnt[i][jj] - cnt[i][j] > 0)
                                dp[i][jj][p+1] = (dp[i][jj][p+1] + dp[i][j][p]) % mod;
                    }
        return dp[rows][cols][k];
    }
}
