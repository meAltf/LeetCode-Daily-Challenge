/********************************************************************************************************************************

----------------
QUESTION NO-472
----------------

Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

------------------------------------------------------------------------------------

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".


Example 2:

Input: words = ["cat","dog","catdog"]

Output: ["catdog"]

----------------------------------------------------------------------------------------


**********************************************************************************************************************************/

class Solution {

    Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> result = new LinkedList<>();
        
        for(String s: words){
            set.add(s);
        }
        
        for(int i=0; i<words.length; i++)
        {
            String w = words[i];
            if(isPresent(w)){
                result.add(w);
            }
            
        }
        return result;
    }
    public boolean isPresent(String word)
    {
        for(int i=0; i<word.length();i++) 
         {
            String prefix = word.substring(0,i+1);
            String suffix = word.substring(i+1,word.length());
            if((set.contains(prefix) && set.contains(suffix)) || set.contains(prefix) && isPresent(suffix)){
                return true;
                }
         }
       return false;
    }
}
