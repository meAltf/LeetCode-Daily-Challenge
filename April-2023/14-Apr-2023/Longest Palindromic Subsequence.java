/******************************************************************************************************************************************************
-----------------------------
Level- Medium
Question No- 516
-----------------------------
Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

___________________________________________________________________________________________________ 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int longestPalindromeSubseq(String s) {
        //Reverse String
        StringBuilder strb = new StringBuilder(s);
        String str=strb.reverse().toString();

        int n=s.length();
        int m=str.length();
        int dp[][]=new int[n+1][m+1];
        
        //base case
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s.charAt(i-1)==str.charAt(j-1))  dp[i][j]=1+dp[i-1][j-1];

                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}
