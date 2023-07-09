/******************************************************************************************************************************************************
--------------------
Level- Hard
Question No-2272
----------------------
The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. 
Note the two characters may or may not be the same.

Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.

A substring is a contiguous sequence of characters within a string.

___________________________________________________________________________________________________
 

Example 1:

Input: s = "aababbb"
Output: 3
Explanation:
All possible variances along with their respective substrings are listed below:
- Variance 0 for substrings "a", "aa", "ab", "abab", "aababb", "ba", "b", "bb", and "bbb".
- Variance 1 for substrings "aab", "aba", "abb", "aabab", "ababb", "aababbb", and "bab".
- Variance 2 for substrings "aaba", "ababbb", "abbb", and "babb".
- Variance 3 for substring "babbb".
Since the largest possible variance is 3, we return it.

Example 2:

Input: s = "abcde"
Output: 0
Explanation:
No letter occurs more than once in s, so the variance of every substring is 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution {
    public int largestVariance(String s) {
        int output = 0;
        int[][] dif = new int[26][26];
        int[][] difB = new int [26][26];
        for(int i = 0; i < 26; i++){
            Arrays.fill(difB[i], -s.length());
        }

        for(int j = 0; j < s.length(); j++){
            int ch = s.charAt(j) - 'a';
            for(int k = 0; k < 26; k++){
                if(k == ch) continue;
                ++dif[ch][k];
                ++difB[ch][k];
                difB[k][ch] = --dif[k][ch];
                dif[k][ch] = Math.max(dif[k][ch], 0);
                output = Math.max(output, Math.max(difB[ch][k], difB[k][ch]));

            }
        }
        return output;
    }
}
