/******************************************************************************************************************************************************
---------------------------
Level- Easy
Question NO- 20
----------------------------
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
___________________________________________________________________________________________________

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if (st.isEmpty() || (st.peek() == '(' && c != ')') || (st.peek() == '{' && c != '}') || (st.peek() == '[' && c != ']')) {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
