/*************************************************************************************************************************************************

---------------------
QUESTION NO- 438
---------------------

Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


-------------------------------------------------------------------------------------------------------

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

---------------------------------------------------------------------------------------------------------

***************************************************************************************************************************************************/

-------------------
APPROACH-1
------------------
  
  
  // WE ARE USING SLIDING WINDOW APPROACH FOR THIS PROBLEM

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        
        // Basic check to see if the array is empty or not
        if(s.length() == 0 || s == null) return output;
        
        // This array will store the count of each and every alphabet
        // The size will be 26 as there are only 26 letters in alphabets
        int[] charCount = new int[26];
        
        for(char c : p.toCharArray()){
            // basically incrementing the assigned index for each alphabet 
            charCount[c - 'a']++;
        }
// After this loop we will have our frequencies of each alphabet in the charCount array
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right < s.length()){
// this checks if the value present at the right index is atleast 1 as that would mean that the current alphabet is there in the p string , we all decrement the count of the alphabet after we found it and move the right pointer 1 step forward
            
            if(charCount[s.charAt(right++) - 'a']-- >= 1) count--;
            
            // if our count reaches 0 that means we fount the Anagram that we need and we just add the starting index of the anagram
            if(count == 0) output.add(left);
            
            // if we found the whole anagram and charcount at the left index is still greater than or equal to 0, then we move the left pointer forward and we increment the charcount back so it does not affect the approach in the next step
            if(right - left == p.length() && charCount[s.charAt(left++) - 'a']++ >= 0) count ++;
        }
        
        return output;
    }
}


----------------
  APPROACH-2
----------------
  
  
  		class Solution {
		public List<Integer> findAnagrams(String s, String p) {
			List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = p.length();
			if(m>n){
                return ans;
            }
			int []arrs = new int[26];
			int []arrp = new int[26];
			for(int i=0;i<m;i++){
				arrs[s.charAt(i)-'a']++;
				arrp[p.charAt(i)-'a']++;
			}
			for(int i=0;i<=n-m;i++){
			    if(iszero(arrs,arrp)){
                    ans.add(i);
                }
				arrs[s.charAt(i)-'a']--;
				if(i+m < n){
                    arrs[s.charAt(i+m)-'a']++;
                }
			}
			return ans;
		}
        public boolean iszero(int [] arrs, int []arrp){
            for(int j=0;j<26;j++){
				if(arrs[j]!=arrp[j]){
					return false;
				    }
				}
            return true;
        }
	}
