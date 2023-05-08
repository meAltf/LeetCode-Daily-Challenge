/******************************************************************************************************************************************************
-----------------------
Level- Easy
Question No- 1572
----------------------
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

___________________________________________________________________________________________________ 

Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

/**
 * @param {number[][]} mat
 * @return {number}
 */
var diagonalSum = function (mat) {

    if (mat.length == 0) return 0;
        
    let sum = 0
    
    for (i = 0; i < mat.length; i++) {
        
        if (i !== mat.length - i - 1)
            sum = sum + mat[i][i] + mat[i][mat.length - i - 1]
        else
            sum = sum + mat[i][i]
    }
    return sum
};
