/******************************************************************************************************************************************************
--------------------
Level- Medium
Question No- 1456
----------------------
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
__________________________________________________________________________________________________

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public boolean isVowel(char c){
        if(c=='a' || c== 'e' || c== 'i' || c== 'o' || c== 'u')
            return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i=0;
        int count = 0;
        for(;i<k;i++){ // First window of size k
            if(isVowel(s.charAt(i)))
                count++;
        }
        int ans = count;
        for(;i<n;i++){ // Remaining n-k windows
            if(isVowel(s.charAt(i))) // If new character is vowel the increment count
                count++;
            if(isVowel(s.charAt(i-k))) // If previous character is vowel then decrement count
                count--;
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
