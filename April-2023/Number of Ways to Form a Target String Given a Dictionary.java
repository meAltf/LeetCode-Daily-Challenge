/******************************************************************************************************************************************************
---------------------
Level- Hard
Question No- 1639
----------------------
You are given a list of strings of the same length words and a string target.

Your task is to form target using the given words under the following rules:

target should be formed from left to right.
To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. 
In other words, all characters to the left of or at index k become unusuable for every string.
Repeat the process until you form the string target.
Notice that you can use multiple characters from the same string in words provided the conditions above are met.

Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

___________________________________________________________________________________________________ 

Example 1:

Input: words = ["acca","bbbb","caca"], target = "aba"
Output: 6
Explanation: There are 6 ways to form target.
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
"aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
"aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
"aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
Example 2:

Input: words = ["abba","baab"], target = "bab"
Output: 4
Explanation: There are 4 ways to form target.
"bab" -> index 0 ("baab"), index 1 ("baab"), index 2 ("abba")
"bab" -> index 0 ("baab"), index 1 ("baab"), index 3 ("baab")
"bab" -> index 0 ("baab"), index 2 ("baab"), index 3 ("baab")
"bab" -> index 1 ("abba"), index 2 ("baab"), index 3 ("baab")


___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int numWays(String[] words, String target) {
        long []dp = new long[target.length()];
        long mod = 1000000007;
        for(int i=0;i<words[0].length();i++){
            int []a = new int[26];
            for(int j=0;j<words.length;j++){
                a[words[j].charAt(i)-'a'] ++;
            }
            for(int j= Math.min(i, target.length()-1);j>=0;j--){
                if(a[target.charAt(j) - 'a'] > 0){
                    dp[j] += j == 0 ? a[target.charAt(j)-'a'] : dp[j-1]*a[target.charAt(j)-'a'];
                    dp[j] %= mod;
                }
            }
        }
        return (int)dp[dp.length-1];
    }
}
