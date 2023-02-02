/*****************************************************************************************************************************************

--------------------
QUESTION NO-953
--------------------

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of 
lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically 
in this alien language.


----------------------------------------------------------------------------------------------------------

Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules 
"apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).

----------------------------------------------------------------------------------------------------------


*****************************************************************************************************************************************/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        //create an array to allocate memory for each character of alien order
        int[] alien = new int[26];
        for(int i=0; i<order.length(); i++){
            alien[order.charAt(i) -'a'] = i;
        }

        //now compare each character from alien order that it follow order or not
        for(int i=1; i<words.length; i++){
            if(!compare(words[i-1], words[i],alien)){
                return false;
            }
        }
        return true;
        
    }

    //now create compare function it gives boolean return type 
    boolean compare(String a, String b, int[] alien){
        //first, if character matched with both string, then traverse continue.. until the length of a and b not exceeded to their length
        int i= 0;
        while(i<a.length() && i<b.length()){
            if(a.charAt(i) == b.charAt(i)){
                i++;
            }

            //we got different character either from a or b then compare it will be in lexicograhically order or not, if follow order then return true nor false
            else if(alien[a.charAt(i)-'a'] < alien[b.charAt(i) -'a'] ){
                return true;

            }else {
                return false;
            }
        }

        //eadge case, if length of a is greater than length of b then return false
        if(a.length() > b.length()){
            return false;
        }
        
        return true;
    }
}
