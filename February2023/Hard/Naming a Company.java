/******************************************************************************************************************************************************
------------------------
QUESTION NO-2306
-----------------------

You are given an array of strings ideas that represents a list of names to be used in the process of naming a company. The process of naming a company is as follows:

Choose 2 distinct names from ideas, call them ideaA and ideaB.
Swap the first letters of ideaA and ideaB with each other.
If both of the new names are not found in the original ideas, then the name ideaA ideaB (the concatenation of ideaA and ideaB,separated by a space) is a valid companyname.
Otherwise, it is not a valid name.
Return the number of distinct valid names for the company.

---------------------------------------------------------------------------------------

Example 1:

Input: ideas = ["coffee","donuts","time","toffee"]
Output: 6
Explanation: The following selections are valid:
- ("coffee", "donuts"): The company name created is "doffee conuts".
- ("donuts", "coffee"): The company name created is "conuts doffee".
- ("donuts", "time"): The company name created is "tonuts dime".
- ("donuts", "toffee"): The company name created is "tonuts doffee".
- ("time", "donuts"): The company name created is "dime tonuts".
- ("toffee", "donuts"): The company name created is "doffee tonuts".
Therefore, there are a total of 6 distinct company names.

The following are some examples of invalid selections:
- ("coffee", "time"): The name "toffee" formed after swapping already exists in the original array.
- ("time", "toffee"): Both names are still the same after swapping and exist in the original array.
- ("coffee", "toffee"): Both names formed after swapping already exist in the original array.

Example 2:

Input: ideas = ["lack","back"]
Output: 0
Explanation: There are no valid selections. Therefore, 0 is returned.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
public long distinctNames(String[] ideas) {

        // create array of ArrayList
        List<String> arr[] = new ArrayList[26];               
        long disName = 0; 

        // assign new ArrayList to each index                                  
        for(int i = 0; i < 26; i++)                           
            arr[i] = new ArrayList<>();

        // store each string A/C to its 1st char
        for(String s : ideas)
            arr[s.charAt(0) - 'a'].add(s.substring(1));       

        // store all strings of arr[i] & arr[j]
        for(int i = 0; i < 25; i++) {
            for(int j = i + 1; j < 26; j++) {
                Set<String> set = new HashSet<>();            

                set.addAll(arr[i]);
                set.addAll(arr[j]);

                // no. of pairs possible
                disName += (arr[i].size() - set.size()) * (arr[j].size() - set.size());     
            }
        }

        return disName * 2;
    }
}
