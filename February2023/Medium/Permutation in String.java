/*****************************************************************************************************************************************

------------------
QUESTION NO-567
------------------

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.


----------------------------------------------------------------------------------------------------------

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

----------------------------------------------------------------------------------------------------------

*****************************************************************************************************************************************/

public class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        
//If s1 is larger than s2 return false
        if(s1.length()>s2.length()){
            return false;
        }

        int i=0;
        int j=s1.length()-1;
//get frequencies
        int[] freqS1 = getCount(s1);
        int[] freqS2 = getCount(s2.substring(0,j));

        while(j<s2.length()){
//Add the new character in the window to the freq array
            freqS2[s2.charAt(j)-'a']++;
//Check if both arrays are equal
            if(Arrays.equals(freqS1,freqS2)){
                return true;
            }
//Remove character since the sliding window will be moving
            freqS2[s2.charAt(i)-'a']--;
//Move window
            i++;
            j++;
        }
        return false;
    }

    private static int[] getCount(String s){
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        return count;
    }
}
