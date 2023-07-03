/******************************************************************************************************************************************************
--------------------
Level- Easy
Question No- 859
------------------------

Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 
___________________________________________________________________________________________________


Example 1:

Input: s = "ab", goal = "ba"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
Example 2:

Input: s = "ab", goal = "ab"
Output: false
Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
Example 3:

Input: s = "aa", goal = "aa"
Output: true
Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)){
            Set<Character> set = new HashSet<>();
            for (char c : A.toCharArray())
                set.add(c);
            return set.size() < A.length();
        }
        else{
            List<Integer> list = new ArrayList<>();
            for (int i = 0;i<A.length();i++)
                if (A.charAt(i) != B.charAt(i)) list.add(i);
            return list.size() == 2 && A.charAt(list.get(0)) == B.charAt(list.get(1)) && B.charAt(list.get(0)) == A.charAt(list.get(1));
        }
    }
}
