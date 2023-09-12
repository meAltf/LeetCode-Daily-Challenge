/******************************************************************************************************************************************************
-----------------------
Level- Medium
Quetion No- 1647
----------------------
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2,
while the frequency of 'b' is 1.

 
___________________________________________________________________________________________________


Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.

Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        int deletions = 0;
        HashSet<Integer> used_frequencies = new HashSet<>();
        
        for (char c : s.toCharArray()) {
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        
        for (int freq : cnt.values()) {
            while (freq > 0 && used_frequencies.contains(freq)) {
                freq--;
                deletions++;
            }
            used_frequencies.add(freq);
        }
        
        return deletions;
    }
}
