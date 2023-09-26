/******************************************************************************************************************************************************
-------------------------
Levek- Medium
Question No- 1081
-----------------------------
Given a string s, return the  lexicographically smallest subsequence of s that contains all the distinct characters of s exactly once.

___________________________________________________________________________________________________

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOcc = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOcc.put(s.charAt(i), i);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && i < lastOcc.get(stack.peek())) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
