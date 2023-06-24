/******************************************************************************************************************************************************
---------------------------
Level- Hard
Question NO- 956
----------------------------

You are installing a billboard and want it to have the largest height. The billboard will have two steel supports, one on each side. Each steel support must be an equal height.

You are given a collection of rods that can be welded together. For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.

Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0.

___________________________________________________________________________________________________ 

Example 1:

Input: rods = [1,2,3,6]
Output: 6
Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.

Example 2:

Input: rods = [1,2,3,4,5,6]
Output: 10
Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.

Example 3:

Input: rods = [1,2]
Output: 0
Explanation: The billboard cannot be supported, so we return 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {
    
    public int tallestBillboard(int[] rods) {
        
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        for (int rod : rods) {
            sum += rod;
        }
        return helper(rods, 0, 0, sum, map);
    }

    private int helper(int[] rods, int index, int diff, 
    int sum, Map<String, Integer> map) {

    // Base case: no rods remaining
    if (index == rods.length) return (diff == 0) ? 0 : Integer.MIN_VALUE;
    

    // Create a unique key for the current state
    String key = index + "+" + diff;

    // Check if the result is already computed
    if (map.containsKey(key)) return map.get(key);
    

    // Exclude the current rod
    int exclude = helper(rods, index + 1, diff, sum, map);

    // Use the current rod on the taller support
    int taller = helper(rods, index + 1, 
    diff + rods[index], sum, map) + rods[index];

    // Use the current rod on the shorter support
    int shorter = helper(rods, index + 1, 
    diff - rods[index], sum, map);

    // Compute the maximum height for the current state
    int maxHeight = Math.max(exclude, Math.max(taller, shorter));

    // Store the computed result in the map
    map.put(key, maxHeight);
    return maxHeight;
    }
}
