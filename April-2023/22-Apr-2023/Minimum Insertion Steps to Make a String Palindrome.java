/******************************************************************************************************************************************************
-----------------------
Level- Hard
Question No- 1312
--------------------------
Given a string s. In one step you can insert any character at any index of the string.

Return the minimum number of steps to make s palindrome.

A Palindrome String is one that reads the same backward as well as forward.
___________________________________________________________________________________________________

Example 1:

Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
Example 2:

Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
Example 3:

Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    // Space optimized logic for the below code
    public int minInsertions(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int prev = 0;
        for (int i = 1; i <= n; i++) {
            prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (s.charAt(i - 1) == s.charAt(n - j)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return n - dp[n];
    }
    /*
    2D array
    public int minInsertions(String s) {
        return s.length()-helper(s,reverse(s));        
    }
    private String reverse(String s)
    {
        String str = new StringBuilder(s).reverse().toString();
        return str;
    }
    private int helper(String seedha, String ulta)
    {
        // Is function me hum longest common subsequence ka length nikalne wale hai
        int n = seedha.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(seedha.charAt(i) == ulta.charAt(j))
                {
                    dp[i+1][j+1]= dp[i][j]+1;
                }
                else
                {
                    dp[i+1][j+1]= Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[n][n];

    }

    */
}
