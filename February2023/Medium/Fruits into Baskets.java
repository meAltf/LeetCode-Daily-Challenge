/******************************************************************************************************************************************************
-------------------------
QUESTION NO-904
----------------------------

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type
of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must 
fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

---------------------------------------------------------------------------------------

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.

Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].

Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

class Solution {
    public int totalFruit(int[] fruits) {
        
        // start: marks the VALID starting position - 1
        // (e.g. [1, 2, 2], start = -1, end = 2, maxlength = 2 - (-1) = 3)
        int res = 0, start = -1;

        // use a 1-D array of size 2 to represent the bucket
        // initialization: -1 means empty slots
        int[] bucket = new int[2];
        Arrays.fill(bucket, -1);
        for (int i = 0; i < fruits.length; i++) {
            int curType = fruits[i];

            // case 1: when bucket is empty, simply add 
            if (bucket[0] == -1 && bucket[1] == -1) {
                bucket[0] = curType;
            } 
            
            // case 2: when there is one empty slot and current type is different, simply add
            else if (bucket[1] == -1 && bucket[0] != curType) {
                bucket[1] = curType;
            } 
            
            // case 3: when bucket is full, need to update the first valid start position
            else if (bucket[1] != curType && bucket[0] != curType) {
                start = update(i, bucket, fruits);
            }

            // update max 
            res = Math.max(res, i - start);
        }
        return res;
    }

    private static int update(int i, int[] bucket, int[] fruits) {
        int curType = fruits[i];
        int lastType = fruits[i - 1];
        int firstValid = i - 1;
        while (firstValid >= 0) {
            if (fruits[--firstValid] != lastType) break;
        }
        bucket[0] = lastType;
        bucket[1] = curType;
        return firstValid;
    }
}
