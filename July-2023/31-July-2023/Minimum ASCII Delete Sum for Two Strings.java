--------------------------------------------------------------------------------------------------------------------------------------------------------------------
----------------------
Level- MEdium
Question No-712
---------------------------------------------

Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

-------------------------------------------- 

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
  
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

  class Solution {
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(s1, s2, 0, 0);
    }

    private int solve(String s1, String s2, int i, int j) {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }
            return sum;
        }
        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }
            return sum;
        }
        int nt = Math.min(s1.charAt(i) + solve(s1, s2, i + 1, j), s2.charAt(j) + solve(s1, s2, i, j + 1));
        int tk = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {
            tk = solve(s1, s2, i + 1, j + 1);
        }
        return dp[i][j] = Math.min(nt, tk);
    }
}
