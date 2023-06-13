/******************************************************************************************************************************************************
----------------------
Level- Medium
Question No- 2352
------------------------
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

__________________________________________________________________________________________________
 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
Example 2:


Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/
class Solution {
    public int equalPairs(int[][] grid) {

        int count = 0;
        int length = grid.length;

        for(int row=0; row<length; row++){

            for(int col=0; col<length; col++){

                boolean isEqual = true;

                for(int i=0; i<length; i++){
                    
                    if(grid[row][i] != grid[i][col]){

                        isEqual = false;
                        break;
                    }
                }

                //increase here count everytime
                if(isEqual) count++;
            }
        }
        return count;
    }
}
